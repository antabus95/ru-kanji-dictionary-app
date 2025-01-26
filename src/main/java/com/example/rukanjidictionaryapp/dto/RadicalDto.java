package com.example.rukanjidictionaryapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class RadicalDto {

    private Long id;

    private String name;

    private Integer number;

    private Integer strokeCount;

    private List<RadicalFormDto> radicalForms;

}
