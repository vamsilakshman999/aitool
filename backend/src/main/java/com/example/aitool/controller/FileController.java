package com.example.aitool.controller;

import com.example.aitool.model.StoredFile;
import com.example.aitool.repository.StoredFileRepository;
import com.example.aitool.service.SummaryService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
@Validated
public class FileController {
    private final StoredFileRepository repository;
    private final SummaryService summaryService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<StoredFile> upload(@RequestPart("file") MultipartFile file) throws IOException {
        StoredFile sf = new StoredFile();
        sf.setFilename(StringUtils.cleanPath(file.getOriginalFilename()));
        sf.setContentType(file.getContentType());
        // TODO: store file content or upload to S3
        sf = repository.save(sf);
        CompletableFuture<String> summaryFut = summaryService.summarizeFile(sf.getFilename());
        summaryFut.thenAccept(summary -> {
            sf.setSummary(summary);
            repository.save(sf);
        });
        return ResponseEntity.ok(sf);
    }

    @PostMapping("/url")
    public ResponseEntity<StoredFile> addByUrl(@RequestParam @NotBlank String url) {
        StoredFile sf = new StoredFile();
        sf.setUrl(url);
        sf.setFilename(url.substring(url.lastIndexOf('/') + 1));
        sf = repository.save(sf);
        CompletableFuture<String> summaryFut = summaryService.summarizeFile(url);
        summaryFut.thenAccept(summary -> {
            sf.setSummary(summary);
            repository.save(sf);
        });
        return ResponseEntity.ok(sf);
    }

    @GetMapping
    public List<StoredFile> list() {
        return repository.findAll();
    }
}
