package com.example.rukanjidictionaryapp.repository;

import com.example.rukanjidictionaryapp.model.Radical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RadicalRepository extends JpaRepository<Radical, Long> {

    @Query(value = "SELECT * FROM radicals r WHERE r.number = :number", nativeQuery = true)
    Optional<Radical> findByNumber(@Param("number") Integer number);

    @Query(value = "SELECT * FROM radicals r WHERE r.stroke_count = :strokeCount", nativeQuery = true)
    Optional<List<Radical>> findAllByStrokeCount(@Param("strokeCount") Integer strokeCount);

    @Query(value = """
        SELECT r.* FROM radicals r
        JOIN radical_forms rf ON rf.radical_id = r.id
        WHERE rf.spelling = :spelling OR rf.alt_spelling = :spelling
        """, nativeQuery = true)
    Optional<Radical> findBySpelling(@Param("spelling") String spelling);

}
