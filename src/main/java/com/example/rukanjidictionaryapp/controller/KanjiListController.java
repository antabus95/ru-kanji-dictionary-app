package com.example.rukanjidictionaryapp.controller;

import com.example.rukanjidictionaryapp.model.KanjiList;
import com.example.rukanjidictionaryapp.service.KanjiListElementService;
import com.example.rukanjidictionaryapp.service.KanjiListService;
import com.example.rukanjidictionaryapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/kanjidic/mylists")
@RequiredArgsConstructor
public class KanjiListController {

    private final KanjiListService kanjiListService;
    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiList> getAll(){
        return kanjiListService.getAllKanjiLists(userService.getCurrentUser().getId());
    }

    @GetMapping("/{title}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public KanjiList getKanjiListByTitle(@PathVariable String title){
        return kanjiListService.getByTitle(title);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public KanjiList update(@RequestBody KanjiList kanjiList){
        return kanjiListService.update(kanjiList);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public KanjiList create(@RequestBody KanjiList kanjiList){
        return kanjiListService.create(kanjiList, userService.getCurrentUser().getId());
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public void delete(@RequestBody KanjiList kanjiList){
        kanjiListService.delete(kanjiList.getId());
    }


}
