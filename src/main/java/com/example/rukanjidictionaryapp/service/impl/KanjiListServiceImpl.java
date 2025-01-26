package com.example.rukanjidictionaryapp.service.impl;

import com.example.rukanjidictionaryapp.model.KanjiList;
import com.example.rukanjidictionaryapp.model.User;
import com.example.rukanjidictionaryapp.repository.KanjiListRepository;
import com.example.rukanjidictionaryapp.service.KanjiListService;
import com.example.rukanjidictionaryapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KanjiListServiceImpl implements KanjiListService {

    private final KanjiListRepository kanjiListRepository;
    private final UserService userService;

    @Override
    public KanjiList create(KanjiList kanjiList, Long userId) {
        User user = userService.getById(userId);
        user.getKanjiLists().add(kanjiList);
        userService.save(user);
        return kanjiList;
    }

    @Override
    public KanjiList update(KanjiList kanjiList) {
        return kanjiListRepository.save(kanjiList);
    }

    @Override
    public List<KanjiList> getAllKanjiLists(Long userId) {
        return kanjiListRepository.findAllKanjiListByUserId(userId).orElseThrow();
    }

    @Override
    public KanjiList getById(Long id) {
        return kanjiListRepository.findById(id).orElseThrow();
    }

    @Override
    public KanjiList getByTitle(String title) {
        return kanjiListRepository.findByTitle(title).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        kanjiListRepository.deleteById(id);
    }
}
