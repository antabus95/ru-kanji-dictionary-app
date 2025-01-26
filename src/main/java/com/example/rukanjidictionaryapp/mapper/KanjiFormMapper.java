package com.example.rukanjidictionaryapp.mapper;

import com.example.rukanjidictionaryapp.dto.KanjiFormDto;
import com.example.rukanjidictionaryapp.model.Kanji;
import com.example.rukanjidictionaryapp.service.KanjiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KanjiFormMapper implements Mapper<Kanji, KanjiFormDto>{

    private final KanjiService kanjiService;

    @Override
    public KanjiFormDto toDto(Kanji kanji) {
        KanjiFormDto kanjiFormDto = new KanjiFormDto();
        kanjiFormDto.setId(kanji.getId());
        kanjiFormDto.setSpelling(kanji.getSpelling());
        return kanjiFormDto;
    }

    @Override
    public Kanji toEntity(KanjiFormDto kanjiFormDto) {
        return kanjiService.getById(kanjiFormDto.getId());
    }
}
