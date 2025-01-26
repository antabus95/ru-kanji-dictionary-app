package com.example.rukanjidictionaryapp.service;

import com.example.rukanjidictionaryapp.model.Kanji;

import java.util.List;

public interface KanjiService {

    Kanji getById(Long id);

    List<Kanji> getKanji(String str);

    List<Kanji> getAll();

    List<Kanji> getAllByJlptLvl(Integer jlptLvl);

    List<Kanji> getAllByKankenLvl(Float kankenLvl);

    List<Kanji> getAllByStrokeCount(Integer strokeCount);

    List<Kanji> getAllJoyo();

    List<Kanji> getAllJinmeiyo();

    List<Kanji> getAllByRadicalId(Long radicalId);

    Kanji update(Kanji kanji);

    Kanji create(Kanji kanji);

    void delete(Long id);

}
