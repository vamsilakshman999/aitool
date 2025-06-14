package com.example.aitool.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class SummaryService {
    @Async
    public CompletableFuture<String> summarizeFile(String url) {
        // TODO: Integrate OpenAI API call here for RAG-based summary
        return CompletableFuture.completedFuture("Summary for " + url);
    }
}
