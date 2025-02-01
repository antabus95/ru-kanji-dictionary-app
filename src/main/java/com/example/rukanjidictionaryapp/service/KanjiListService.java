package com.example.rukanjidictionaryapp.service;

import com.example.rukanjidictionaryapp.model.KanjiList;
import java.util.List;

public interface KanjiListService {

    KanjiList create(KanjiList kanjiList, Long userId);

    KanjiList update(KanjiList kanjiList);

    List<KanjiList> getAllKanjiLists(Long userId);

    KanjiList getById(Long id);

    KanjiList getByTitle(Long userId, String title);

    void delete(Long userId, Long id);


}
