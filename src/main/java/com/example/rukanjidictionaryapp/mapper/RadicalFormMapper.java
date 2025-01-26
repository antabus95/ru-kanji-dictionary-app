package com.example.rukanjidictionaryapp.mapper;

import com.example.rukanjidictionaryapp.dto.RadicalFormDto;
import com.example.rukanjidictionaryapp.model.RadicalForm;
import org.springframework.stereotype.Component;

@Component
public class RadicalFormMapper implements Mapper<RadicalForm, RadicalFormDto> {

    @Override
    public RadicalFormDto toDto(RadicalForm radicalForm) {
        if(radicalForm == null) return null;

        RadicalFormDto radicalFormDto = new RadicalFormDto();
        radicalFormDto.setId(radicalForm.getId());
        radicalFormDto.setFormName(radicalForm.getFormName());
        radicalFormDto.setSpelling(radicalForm.getSpelling());
        radicalFormDto.setAltSpelling(radicalForm.getAltSpelling());

        return radicalFormDto;
    }

    @Override
    public RadicalForm toEntity(RadicalFormDto radicalFormDto) {
        if(radicalFormDto == null) return null;

        RadicalForm radicalForm = new RadicalForm();
        radicalForm.setId(radicalFormDto.getId());
        radicalForm.setFormName(radicalFormDto.getFormName());
        radicalForm.setSpelling(radicalFormDto.getSpelling());
        radicalForm.setAltSpelling(radicalFormDto.getAltSpelling());

        return radicalForm;
    }

}
