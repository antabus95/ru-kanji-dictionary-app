package com.example.rukanjidictionaryapp.service.impl;

import com.example.rukanjidictionaryapp.model.Kanji;
import com.example.rukanjidictionaryapp.repository.KanjiRepository;
import com.example.rukanjidictionaryapp.service.KanjiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KanjiServiceImpl implements KanjiService {

    private final KanjiRepository kanjiRepository;

    @Override
    @Transactional(readOnly = true)
    public Kanji getById(Long id) {
        return kanjiRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Kanji not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kanji> getKanji(String str) {
        return kanjiRepository.findKanji(str).orElseThrow(()-> new IllegalArgumentException("Kanji not found"));
    }

    @Override
    @Transactional
    public List<Kanji> getAll() {
        return kanjiRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kanji> getAllByJlptLvl(Integer jlptLvl) {
        return kanjiRepository.findAllByJlptLvl(jlptLvl).orElseThrow(()-> new IllegalArgumentException("Kanji not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kanji> getAllByKankenLvl(Float kankenLvl) {
        return kanjiRepository.findAllByKankenLvl(kankenLvl).orElseThrow(()-> new IllegalArgumentException("Kanji not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kanji> getAllByStrokeCount(Integer strokeCount) {
        return kanjiRepository.findAllByStrokeCount(strokeCount).orElseThrow(()-> new IllegalArgumentException("Kanji not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kanji> getAllJoyo() {
        return kanjiRepository.findAllJoyoKanji().orElseThrow(()-> new IllegalArgumentException("Kanji not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kanji> getAllJinmeiyo() {
        return kanjiRepository.findAllJinmeiyoKanji().orElseThrow(()-> new IllegalArgumentException("Kanji not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Kanji> getAllByRadicalId(Long radicalId) {
        return kanjiRepository.findAllByRadicalId(radicalId).orElseThrow(()-> new IllegalArgumentException("Kanji not found"));
    }

    @Override
    @Transactional
    public Kanji update(Kanji kanji) {
        kanjiRepository.save(kanji);
        return kanji;
    }

    @Override
    @Transactional
    public Kanji create(Kanji kanji) {
        if(kanjiRepository.findKanji(kanji.getSpelling()).isPresent()) {
            throw new IllegalStateException("Kanji already exists.");
        }
        kanjiRepository.save(kanji);
        return kanji;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        kanjiRepository.deleteById(id);
    }
}
