package com.example.rukanjidictionaryapp.service;

import com.example.rukanjidictionaryapp.model.KanjiMeaning;

public interface KanjiMeaningService {

    KanjiMeaning getById(Long id);

    KanjiMeaning update(KanjiMeaning kanjiMeaning);

    KanjiMeaning create(KanjiMeaning kanjiMeaning);

}
