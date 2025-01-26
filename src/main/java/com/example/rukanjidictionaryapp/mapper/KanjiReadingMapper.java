package com.example.rukanjidictionaryapp.mapper;

import com.example.rukanjidictionaryapp.dto.KanjiReadingDto;
import com.example.rukanjidictionaryapp.model.KanjiReading;
import org.springframework.stereotype.Component;

@Component
public class KanjiReadingMapper implements Mapper<KanjiReading, KanjiReadingDto> {

    public KanjiReadingDto toDto(KanjiReading kanjiReading) {

        if (kanjiReading == null) return null;

        KanjiReadingDto kanjiReadingDto = new KanjiReadingDto();
        kanjiReadingDto.setId(kanjiReading.getId());
        kanjiReadingDto.setText(kanjiReading.getText());
        kanjiReadingDto.setReadingType(kanjiReading.getReadingType());
        kanjiReadingDto.setJoyo(kanjiReading.isJoyo());
        kanjiReadingDto.setChineseReadingCategory(kanjiReading.getChineseReadingCategory());
        return kanjiReadingDto;

    }

    public KanjiReading toEntity(KanjiReadingDto kanjiReadingDto) {

        if (kanjiReadingDto == null) return null;

        KanjiReading kanjiReading = new KanjiReading();
        kanjiReading.setId(kanjiReadingDto.getId());
        kanjiReading.setText(kanjiReadingDto.getText());
        kanjiReading.setReadingType(kanjiReadingDto.getReadingType());
        kanjiReading.setJoyo(kanjiReadingDto.isJoyo());
        kanjiReading.setChineseReadingCategory(kanjiReadingDto.getChineseReadingCategory());
        return kanjiReading;

    }
}
