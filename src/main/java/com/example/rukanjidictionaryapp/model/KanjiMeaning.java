package com.example.rukanjidictionaryapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "kanji_meanings")
public class KanjiMeaning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meaning;

    @ManyToOne
    @JoinColumn(name = "kanji_id")
    @JsonBackReference
    private Kanji kanji;

}
