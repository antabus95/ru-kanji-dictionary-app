package com.example.rukanjidictionaryapp.repository;

import com.example.rukanjidictionaryapp.model.KanjiMeaning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KanjiMeaningRepository extends JpaRepository<KanjiMeaning, Long> {

}
