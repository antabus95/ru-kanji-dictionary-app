package com.example.rukanjidictionaryapp.repository;

import com.example.rukanjidictionaryapp.model.KanjiListElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface KanjiListElementRepository extends JpaRepository<KanjiListElement, Long> {

    @Query(value = "SELECT kle FROM kanji_list_elements kle WHERE kanji_list_id = : kanjiListId", nativeQuery = true)
    Optional<List<KanjiListElement>> findAllKanjiListElementsByKanjiListId(Long kanjiListId);

}
