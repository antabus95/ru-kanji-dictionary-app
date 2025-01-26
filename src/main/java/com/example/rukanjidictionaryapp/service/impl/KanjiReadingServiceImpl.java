package com.example.rukanjidictionaryapp.service.impl;

import com.example.rukanjidictionaryapp.model.KanjiReading;
import com.example.rukanjidictionaryapp.repository.KanjiReadingRepository;
import com.example.rukanjidictionaryapp.service.KanjiReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class KanjiReadingServiceImpl implements KanjiReadingService {

    private final KanjiReadingRepository kanjiReadingRepository;

    @Override
    @Transactional(readOnly = true)
    public KanjiReading getById(Long id) {
        return kanjiReadingRepository.findById(id).orElseThrow(()-> new IllegalStateException("Reading Not Found"));
    }

    @Override
    @Transactional
    public KanjiReading create(KanjiReading kanjiReading) {
        kanjiReadingRepository.save(kanjiReading);
        return kanjiReading;
    }

    @Override
    @Transactional
    public KanjiReading update(KanjiReading kanjiReading) {
        kanjiReadingRepository.save(kanjiReading);
        return kanjiReading;
    }
}
