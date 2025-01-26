package com.example.rukanjidictionaryapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "kanji_list_elements")
public class KanjiListElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Kanji kanji;

    private String note;

    @ManyToOne
    @JoinColumn(name = "kanji_list_id")
    @JsonBackReference
    private KanjiList kanjiList;

}
