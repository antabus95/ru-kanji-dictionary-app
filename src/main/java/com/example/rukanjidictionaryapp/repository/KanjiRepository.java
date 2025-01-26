package com.example.rukanjidictionaryapp.repository;

import com.example.rukanjidictionaryapp.model.Kanji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface KanjiRepository extends JpaRepository<Kanji, Long> {

    //Find kanji by its spelling, meaning or reading
    @Query(value = """
        SELECT DISTINCT k.*
        FROM kanjies k
        JOIN kanji_readings r ON r.kanji_id = k.id
        JOIN kanji_meanings m ON m.kanji_id = k.id
        WHERE r.text = :string
                   OR m.meaning ILIKE :string
                   OR k.spelling = :string
        """, nativeQuery = true)
    Optional<List<Kanji>> findKanji(@Param("string") String string);

    @Query(value = "SELECT * FROM kanjies k WHERE k.jlpt_lvl = :jlptLvl", nativeQuery = true)
    Optional<List<Kanji>> findAllByJlptLvl(@Param("jlptLvl") Integer jlptLvl);

    @Query(value = "SELECT * FROM kanjies k WHERE k.kanken_lvl = :kankenLvl", nativeQuery = true)
    Optional<List<Kanji>> findAllByKankenLvl(@Param("kankenLvl") Float kankenLvl);

    @Query(value = "SELECT * FROM kanjies k WHERE k.stroke_count = :strokeCount", nativeQuery = true)
    Optional<List<Kanji>> findAllByStrokeCount(@Param("strokeCount") Integer strokeCount);

    @Query(value = "SELECT * FROM kanjies k WHERE k.category = 'JOYO'", nativeQuery = true)
    Optional<List<Kanji>> findAllJoyoKanji();

    @Query(value = "SELECT * FROM kanjies k WHERE k.category = 'JINMEIYO'", nativeQuery = true)
    Optional<List<Kanji>> findAllJinmeiyoKanji();

    @Query(value = "SELECT DISTINCT k.* FROM kanjies k JOIN radical_forms rf ON rf.radical_id = :radicalId", nativeQuery = true)
    Optional<List<Kanji>> findAllByRadicalId(@Param("radicalId") Long radicalId);

}
