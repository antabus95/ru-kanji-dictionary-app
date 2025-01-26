package com.example.rukanjidictionaryapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "kanji_lists")
public class KanjiList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @CollectionTable(name = "kanji_lists_kanji_list_element")
    @OneToMany
    @JoinColumn(name = "kanji_list_element_id")
    private List<KanjiListElement> kanjiListElements;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
