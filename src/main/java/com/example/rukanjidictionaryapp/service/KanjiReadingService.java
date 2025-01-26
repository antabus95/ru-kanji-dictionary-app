package com.example.rukanjidictionaryapp.service;

import com.example.rukanjidictionaryapp.model.KanjiReading;

public interface KanjiReadingService {

    KanjiReading getById(Long id);

    KanjiReading create(KanjiReading kanjiReading);

    KanjiReading update(KanjiReading kanjiReading);

}
