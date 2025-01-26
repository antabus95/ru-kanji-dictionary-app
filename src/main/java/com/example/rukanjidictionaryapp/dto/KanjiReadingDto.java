package com.example.rukanjidictionaryapp.dto;

import com.example.rukanjidictionaryapp.model.ChineseReadingCategory;
import com.example.rukanjidictionaryapp.model.ReadingType;
import lombok.Data;

@Data
public class KanjiReadingDto {

    private Long id;

    private String text;

    private ReadingType readingType;

    private ChineseReadingCategory chineseReadingCategory;

    private boolean isJoyo;

}
