package com.example.rukanjidictionaryapp.mapper;

import com.example.rukanjidictionaryapp.dto.*;
import com.example.rukanjidictionaryapp.model.Kanji;
import com.example.rukanjidictionaryapp.model.KanjiMeaning;
import com.example.rukanjidictionaryapp.model.KanjiReading;
import com.example.rukanjidictionaryapp.model.RadicalForm;
import com.example.rukanjidictionaryapp.service.KanjiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class KanjiMapper implements Mapper<Kanji, KanjiDto> {

    private final Mapper<KanjiReading, KanjiReadingDto> kanjiReadingMapper;
    private final Mapper<KanjiMeaning, KanjiMeaningDto> kanjiMeaningMapper;
    private final Mapper<RadicalForm, RadicalFormDto> radicalFormMapper;
    private final Mapper<Kanji, KanjiFormDto> kanjiFormMapper;

    private final KanjiService kanjiService;

    @Override
    public KanjiDto toDto(Kanji kanji) {
        if(kanji == null) return null;

        KanjiDto kanjiDto = new KanjiDto();
        kanjiDto.setId(kanji.getId());
        kanjiDto.setCategory(kanji.getCategory());
        kanjiDto.setSpelling(kanji.getSpelling());
        kanjiDto.setEtymology(kanji.getEtymology());
        kanjiDto.setJisCode(kanji.getJisCode());
        kanjiDto.setUnicode(kanji.getUnicode());
        kanjiDto.setJlptLvl(kanji.getJlptLvl());
        kanjiDto.setKankenLvl(kanji.getKankenLvl());
        kanjiDto.setMeanings(kanji.getMeanings());
        kanjiDto.setStrokeCount(kanji.getStrokeCount());
        kanjiDto.setRadicalFormsDto(radicalFormMapper.toDto(kanji.getRadicalForm()));
        kanjiDto.setReadingsDto(kanji.getReadings().stream()
                .map(kanjiReadingMapper::toDto).collect(Collectors.toList()));

        kanjiDto.setBaseMeaningsDto(kanji.getBaseMeanings().stream()
                .map(kanjiMeaningMapper::toDto).collect(Collectors.toList()));

        List<KanjiFormDto> traditionalFormDtos = new ArrayList<>();
        for (Long traditionalFormId : kanji.getTraditionalFormIds()) {
            traditionalFormDtos.add(kanjiFormMapper.toDto(kanjiService.getById(traditionalFormId)));
        }
        kanjiDto.setTraditionalForms(traditionalFormDtos);

        List<KanjiFormDto> simplifiedFormDtos = new ArrayList<>();
        for (Long simplifiedFormId : kanji.getSimplifiedFormIds()) {
            simplifiedFormDtos.add(kanjiFormMapper.toDto(kanjiService.getById(simplifiedFormId)));
        }
        kanjiDto.setSimplifiedForms(simplifiedFormDtos);


        List<KanjiFormDto> alternativeFormDtos = new ArrayList<>();
        for (Long alternativeFormId : kanji.getAlternativeFormIds()) {
            alternativeFormDtos.add(kanjiFormMapper.toDto(kanjiService.getById(alternativeFormId)));
        }
        kanjiDto.setAlternativeForms(alternativeFormDtos);

        return kanjiDto;
    }

    @Override
    public Kanji toEntity(KanjiDto kanjiDto) {
        if(kanjiDto == null) return null;

        Kanji kanji = new Kanji();
        kanji.setId(kanjiDto.getId());
        kanji.setCategory(kanjiDto.getCategory());
        kanji.setSpelling(kanjiDto.getSpelling());
        kanji.setEtymology(kanjiDto.getEtymology());
        kanji.setJisCode(kanjiDto.getJisCode());
        kanji.setUnicode(kanjiDto.getUnicode());
        kanji.setJlptLvl(kanjiDto.getJlptLvl());
        kanji.setKankenLvl(kanjiDto.getKankenLvl());
        kanji.setMeanings(kanjiDto.getMeanings());
        kanji.setStrokeCount(kanjiDto.getStrokeCount());
        kanji.setRadicalForm(radicalFormMapper.toEntity(kanjiDto.getRadicalFormsDto()));
        kanji.setReadings(kanjiDto.getReadingsDto().stream()
                .map(kanjiReadingMapper::toEntity).collect(Collectors.toList()));
        kanji.setBaseMeanings(kanjiDto.getBaseMeaningsDto().stream()
                .map(kanjiMeaningMapper::toEntity).collect(Collectors.toList()));

        kanji.setTraditionalFormIds(kanjiDto.getTraditionalForms().stream()
            .map(KanjiFormDto::getId).collect(Collectors.toList()));


        return kanji;
    }

}
