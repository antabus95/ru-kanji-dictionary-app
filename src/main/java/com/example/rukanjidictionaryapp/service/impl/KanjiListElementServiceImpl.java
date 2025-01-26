package com.example.rukanjidictionaryapp.service.impl;

import com.example.rukanjidictionaryapp.model.KanjiList;
import com.example.rukanjidictionaryapp.model.KanjiListElement;
import com.example.rukanjidictionaryapp.repository.KanjiListElementRepository;
import com.example.rukanjidictionaryapp.service.KanjiListElementService;
import com.example.rukanjidictionaryapp.service.KanjiListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KanjiListElementServiceImpl implements KanjiListElementService {

    private final KanjiListElementRepository kanjiListElementRepository;
    private final KanjiListService kanjiListService;

    @Override
    public List<KanjiListElement> getAllKanjiListElementByKanjiListId(Long kanjiListId) {
        return kanjiListElementRepository.findAllKanjiListElementsByKanjiListId(kanjiListId).orElseThrow();
    }

    @Override
    public KanjiListElement create(KanjiListElement kanjiListElement, Long kanjiListId) {
        KanjiList kanjiList = kanjiListService.getById(kanjiListId);
        kanjiList.getKanjiListElements().add(kanjiListElement);
        kanjiListService.update(kanjiList);
        return kanjiListElement;
    }

    @Override
    public KanjiListElement update(KanjiListElement kanjiListElement) {
        return kanjiListElementRepository.save(kanjiListElement);
    }

    @Override
    public void delete(Long id) {
        kanjiListElementRepository.deleteById(id);
    }
}
