package com.example.rukanjidictionaryapp.mapper;

import com.example.rukanjidictionaryapp.dto.KanjiMeaningDto;
import com.example.rukanjidictionaryapp.model.KanjiMeaning;
import org.springframework.stereotype.Component;

@Component
public class KanjiMeaningMapper implements Mapper<KanjiMeaning, KanjiMeaningDto> {

    @Override
    public KanjiMeaningDto toDto(KanjiMeaning kanjiMeaning) {

        if(kanjiMeaning == null) return null;

        KanjiMeaningDto kanjiMeaningDto = new KanjiMeaningDto();
        kanjiMeaningDto.setId(kanjiMeaning.getId());
        kanjiMeaningDto.setMeaning(kanjiMeaning.getMeaning());
        return kanjiMeaningDto;

    }

    @Override
    public KanjiMeaning toEntity(KanjiMeaningDto kanjiMeaningDto) {

        if(kanjiMeaningDto == null) return null;

        KanjiMeaning kanjiMeaning = new KanjiMeaning();
        kanjiMeaning.setId(kanjiMeaningDto.getId());
        kanjiMeaning.setMeaning(kanjiMeaningDto.getMeaning());
        return kanjiMeaning;

    }
}
