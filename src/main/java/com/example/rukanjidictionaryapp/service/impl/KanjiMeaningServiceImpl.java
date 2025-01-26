package com.example.rukanjidictionaryapp.service.impl;

import com.example.rukanjidictionaryapp.model.KanjiMeaning;
import com.example.rukanjidictionaryapp.repository.KanjiMeaningRepository;
import com.example.rukanjidictionaryapp.service.KanjiMeaningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class KanjiMeaningServiceImpl implements KanjiMeaningService {

    private final KanjiMeaningRepository kanjiMeaningRepository;

    @Override
    @Transactional(readOnly = true)
    public KanjiMeaning getById(Long id) {
        return kanjiMeaningRepository.findById(id).orElseThrow(()-> new IllegalStateException("Meaning not found"));
    }

    @Override
    @Transactional
    public KanjiMeaning update(KanjiMeaning kanjiMeaning) {
        kanjiMeaningRepository.save(kanjiMeaning);
        return kanjiMeaning;
    }

    @Override
    @Transactional
    public KanjiMeaning create(KanjiMeaning kanjiMeaning) {
        kanjiMeaningRepository.save(kanjiMeaning);
        return kanjiMeaning;
    }
}
