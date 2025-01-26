package com.example.rukanjidictionaryapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "radicals")
public class Radical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private Integer number;

    private Integer strokeCount;

    @OneToMany(mappedBy = "radical", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RadicalForm> radicalForms = new ArrayList<>();

}
