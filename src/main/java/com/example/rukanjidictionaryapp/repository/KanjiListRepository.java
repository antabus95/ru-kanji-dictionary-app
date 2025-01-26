package com.example.rukanjidictionaryapp.repository;

import com.example.rukanjidictionaryapp.model.KanjiList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface KanjiListRepository extends JpaRepository<KanjiList, Long> {

    @Query(value = "SELECT kl FROM kanji_lists kl WHERE user_id = :userId", nativeQuery = true)
    Optional<List<KanjiList>> findAllKanjiListByUserId(Long userId);

    Optional<KanjiList> findByTitle(String title);


}
