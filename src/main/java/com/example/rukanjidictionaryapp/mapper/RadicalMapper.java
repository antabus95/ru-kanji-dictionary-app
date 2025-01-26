package com.example.rukanjidictionaryapp.mapper;

import com.example.rukanjidictionaryapp.dto.RadicalDto;
import com.example.rukanjidictionaryapp.model.Radical;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RadicalMapper implements Mapper<Radical, RadicalDto> {

    private final RadicalFormMapper radicalFormMapper;

    @Override
    public RadicalDto toDto(Radical radical) {
        if(radical == null) return null;
        RadicalDto radicalDto = new RadicalDto();
        radicalDto.setId(radical.getId());
        radicalDto.setName(radical.getName());
        radicalDto.setNumber(radical.getNumber());
        radicalDto.setStrokeCount(radical.getStrokeCount());
        radicalDto.setRadicalForms(radical.getRadicalForms().stream()
                .map(radicalFormMapper::toDto).collect(Collectors.toList()));

        return radicalDto;
    }

    @Override
    public Radical toEntity(RadicalDto radicalDto) {
        if(radicalDto == null) return null;
        Radical radical = new Radical();
        radical.setId(radicalDto.getId());
        radical.setName(radicalDto.getName());
        radical.setNumber(radicalDto.getNumber());
        radical.setStrokeCount(radicalDto.getStrokeCount());
        radical.setRadicalForms(radicalDto.getRadicalForms().stream()
                .map(radicalFormMapper::toEntity).collect(Collectors.toList()));

        return radical;
    }

}
