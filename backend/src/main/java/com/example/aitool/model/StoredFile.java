package com.example.aitool.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StoredFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;
    private String url;
    private String contentType;
    private String summary;
}
