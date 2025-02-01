package com.example.rukanjidictionaryapp.controller;

import com.example.rukanjidictionaryapp.model.KanjiList;
import com.example.rukanjidictionaryapp.service.KanjiListService;
import com.example.rukanjidictionaryapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//ユーザーの勉強リストを管理するコントローラ
@RestController
@RequestMapping("api/v1/kanjidic/mylists")
@RequiredArgsConstructor
public class KanjiListController {

    private final KanjiListService kanjiListService;
    private final UserService userService;

    //自分の勉強リストを全部提示するメソッド
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiList> getAll(){
        return kanjiListService.getAllKanjiLists(userService.getCurrentUser().getId());
    }

    //入力された名前で自分の勉強リストの中から指定の勉強リストを提示するメソッド
    @GetMapping("/{title}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public KanjiList getKanjiListByTitle(@PathVariable String title){
        return kanjiListService.getByTitle(userService.getCurrentUser().getId(), title);
    }

    //既存の勉強リストを更新するメソッド
    @PutMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public KanjiList update(@RequestBody KanjiList kanjiList){
        return kanjiListService.update(kanjiList);
    }

    //新しい勉強リストを作成メソッド
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public KanjiList create(@RequestBody KanjiList kanjiList){
        return kanjiListService.create(kanjiList, userService.getCurrentUser().getId());
    }

    //IDで勉強リストを削除するメソッド
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public void delete(@PathVariable Long id){
        kanjiListService.delete(userService.getCurrentUser().getId(),id);
    }


}
