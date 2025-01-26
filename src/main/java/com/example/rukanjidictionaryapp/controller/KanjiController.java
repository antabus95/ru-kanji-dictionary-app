package com.example.rukanjidictionaryapp.controller;

import com.example.rukanjidictionaryapp.dto.KanjiDto;
import com.example.rukanjidictionaryapp.dto.validation.OnUpdate;
import com.example.rukanjidictionaryapp.mapper.Mapper;
import com.example.rukanjidictionaryapp.model.Kanji;
import com.example.rukanjidictionaryapp.model.KanjiMeaning;
import com.example.rukanjidictionaryapp.model.KanjiReading;
import com.example.rukanjidictionaryapp.service.KanjiMeaningService;
import com.example.rukanjidictionaryapp.service.KanjiReadingService;
import com.example.rukanjidictionaryapp.service.KanjiService;
import com.example.rukanjidictionaryapp.service.RadicalFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/kanjidic")
@RequiredArgsConstructor
@Validated
public class KanjiController {

    private final KanjiService kanjiService;
    private final KanjiReadingService kanjiReadingService;
    private final KanjiMeaningService kanjiMeaningService;

    private final Mapper<Kanji, KanjiDto> kanjiMapper;

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR')")
    public KanjiDto update(@Validated(OnUpdate.class) @RequestBody KanjiDto kanjiDto) {
        Kanji kanji = kanjiMapper.toEntity(kanjiDto);
        Kanji updatedKanji = kanjiService.update(kanji);
        for (KanjiReading kr : updatedKanji.getReadings()) {
            KanjiReading kanjiReading = kanjiReadingService.getById(kr.getId());
            kanjiReading.setKanji(updatedKanji);
            kanjiReadingService.update(kanjiReading);
        }
        for (KanjiMeaning km : updatedKanji.getBaseMeanings()) {
            KanjiMeaning kanjiMeaning = kanjiMeaningService.getById(km.getId());
            kanjiMeaning.setKanji(updatedKanji);
            kanjiMeaningService.update(kanjiMeaning);
        }
        return kanjiMapper.toDto(updatedKanji);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiDto> getAll() {
        List<Kanji> kanjies = kanjiService.getAll();
        return kanjies.stream().map(kanjiMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public KanjiDto getById(@PathVariable Long id) {
        Kanji kanji = kanjiService.getById(id);
        return kanjiMapper.toDto(kanji);
    }

    @GetMapping("/search/{str}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiDto> getKanji(@PathVariable String str) {
        List<Kanji> kanjies = kanjiService.getKanji(str);
        return kanjies.stream().map(kanjiMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/search/radical={radicalId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiDto> getAllByRadical(@PathVariable Long radicalId) {
        List<Kanji> kanjies = kanjiService.getAllByRadicalId(radicalId);
        return kanjies.stream().map(kanjiMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/search/jlpt-n{jlptLvl}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiDto> getAllByJlptLvl(@PathVariable Integer jlptLvl) {
        List<Kanji> kanjies = kanjiService.getAllByJlptLvl(jlptLvl);
        return kanjies.stream().map(kanjiMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/search/knk-{kankenLvl}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiDto> getAllByKankenLvl(@PathVariable Float kankenLvl) {
        List<Kanji> kanjies = kanjiService.getAllByKankenLvl(kankenLvl);
        return kanjies.stream().map(kanjiMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/search/sc={strokeCount}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiDto> getAllByStrokeCount(@PathVariable Integer strokeCount) {
        List<Kanji> kanjies = kanjiService.getAllByStrokeCount(strokeCount);
        return kanjies.stream().map(kanjiMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/joyo")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiDto> getAllJoyo() {
        List<Kanji> kanjies = kanjiService.getAllJoyo();
        return kanjies.stream().map(kanjiMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/jinmeiyo")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<KanjiDto> getAllJinmeiyo() {
        List<Kanji> kanjies = kanjiService.getAllJinmeiyo();
        return kanjies.stream().map(kanjiMapper::toDto).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable Long id) {
        kanjiService.delete(id);
    }

}
