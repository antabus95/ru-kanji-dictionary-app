package com.example.rukanjidictionaryapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "kanji_readings")
public class KanjiReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Enumerated(EnumType.STRING)
    private ReadingType readingType;

    @Enumerated(EnumType.STRING)
    private ChineseReadingCategory chineseReadingCategory;

    private boolean isJoyo;

    @ManyToOne
    @JoinColumn(name = "kanji_id")
    @JsonBackReference
    private Kanji kanji;

}
