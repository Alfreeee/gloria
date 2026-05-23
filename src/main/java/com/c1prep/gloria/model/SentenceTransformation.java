package com.c1prep.gloria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sentence_transformations")
public class SentenceTransformation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    private String originalSentence;  
    private String keyWord;           
    private String solution;          
    private String explanation; // Ottimo per il livello C1
    private int orderIndex;
}