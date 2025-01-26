package com.example.rukanjidictionaryapp.dto;

import com.example.rukanjidictionaryapp.model.KanjiCategory;
import lombok.Data;

import java.util.List;

@Data
public class KanjiDto {

    private Long id;

    private String spelling;

    private List<KanjiReadingDto> readingsDto;

    private List<KanjiMeaningDto> baseMeaningsDto;

    private String meanings;

    private String etymology;

    private Integer strokeCount;

    private KanjiCategory category;

    private RadicalFormDto radicalFormsDto;

    private Integer jlptLvl;

    private Float kankenLvl;

    private String jisCode;

    private String unicode;

    private List<KanjiFormDto> traditionalForms;

    private List<KanjiFormDto> simplifiedForms;

    private List<KanjiFormDto> alternativeForms;

}
