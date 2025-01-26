package com.example.rukanjidictionaryapp.service;

import com.example.rukanjidictionaryapp.model.KanjiListElement;
import java.util.List;

public interface KanjiListElementService {

    List<KanjiListElement> getAllKanjiListElementByKanjiListId(Long kanjiListId);

    KanjiListElement create(KanjiListElement kanjiListElement, Long kanjiListId);

    KanjiListElement update(KanjiListElement kanjiListElement);

    void delete(Long id);

}
