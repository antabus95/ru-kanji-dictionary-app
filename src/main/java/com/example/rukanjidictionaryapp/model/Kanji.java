package com.example.rukanjidictionaryapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "kanjies")
public class Kanji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spelling;

    @OneToMany(mappedBy = "kanji", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<KanjiMeaning> baseMeanings = new ArrayList<>();

    @OneToMany(mappedBy = "kanji", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<KanjiReading> readings = new ArrayList<>();

    private String meanings;

    private String etymology;

    private Integer strokeCount;

    @Enumerated(EnumType.STRING)
    private KanjiCategory category;

    @ManyToOne
    @JoinColumn(name = "radical_form_id")
    @JsonBackReference
    private RadicalForm radicalForm;

    private Integer jlptLvl;

    private Float kankenLvl;

    private String jisCode;

    private String unicode;

    @ElementCollection
    @CollectionTable(name = "traditional_forms", joinColumns = @JoinColumn(name = "kanji_id"))
    @Column(name = "traditional_form_id")
    private List<Long> traditionalFormIds = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "simplified_forms", joinColumns = @JoinColumn(name = "kanji_id"))
    @Column(name = "simplified_form_id")
    private List<Long> simplifiedFormIds = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "alternative_forms", joinColumns = @JoinColumn(name = "kanji_id"))
    @Column(name = "alternative_form_id")
    private List<Long> alternativeFormIds = new ArrayList<>();

}
