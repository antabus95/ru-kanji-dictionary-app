package com.example.rukanjidictionaryapp.controller;

import com.example.rukanjidictionaryapp.model.KanjiListElement;
import com.example.rukanjidictionaryapp.service.KanjiListElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/kanjidic/mylists/{id}")
@RequiredArgsConstructor
public class KanjiListElementController {

    private final KanjiListElementService kanjiListElementService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiListElement> getAll(@PathVariable Long id) {
        return kanjiListElementService.getAllKanjiListElementByKanjiListId(id);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public KanjiListElement update(@RequestBody KanjiListElement kanjiListElement) {
        return kanjiListElementService.update(kanjiListElement);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public KanjiListElement create(@PathVariable Long id, @RequestBody KanjiListElement kanjiListElement) {
        return kanjiListElementService.create(kanjiListElement, id);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public void delete(KanjiListElement kanjiListElement) {
        kanjiListElementService.delete(kanjiListElement.getId());
    }

}
