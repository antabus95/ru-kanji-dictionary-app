package com.example.rukanjidictionaryapp.controller;

import com.example.rukanjidictionaryapp.dto.RadicalDto;
import com.example.rukanjidictionaryapp.dto.validation.OnUpdate;
import com.example.rukanjidictionaryapp.mapper.Mapper;
import com.example.rukanjidictionaryapp.model.Radical;
import com.example.rukanjidictionaryapp.model.RadicalForm;
import com.example.rukanjidictionaryapp.service.RadicalFormService;
import com.example.rukanjidictionaryapp.service.RadicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/kanjidic/radicals")
@RequiredArgsConstructor
@Validated
public class RadicalController {

    private final RadicalService radicalService;
    private final RadicalFormService radicalFormService;
    private final Mapper<Radical, RadicalDto> radicalMapper;

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public RadicalDto update(@Validated(OnUpdate.class) @RequestBody RadicalDto radicalDto) {
        Radical radical = radicalMapper.toEntity(radicalDto);
        Radical updatedRadical = radicalService.update(radical);
        for (RadicalForm rf : updatedRadical.getRadicalForms()) {
            RadicalForm radicalForm = radicalFormService.getById(rf.getId());
            radicalForm.setRadical(radical);
            radicalFormService.update(radicalForm);
        }
        return radicalMapper.toDto(updatedRadical);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<RadicalDto> getAll(){
        List<Radical> radicals = radicalService.getAll();
        return radicals.stream().map(radicalMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public RadicalDto getById(@PathVariable Long id) {
        Radical radical = radicalService.getById(id);
        return radicalMapper.toDto(radical);
    }

    @GetMapping("/search/number={number}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public RadicalDto getByNumber(@PathVariable Integer number) {
        Radical radical = radicalService.getByNumber(number);
        return radicalMapper.toDto(radical);
    }

    @GetMapping("/search/{spelling}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public RadicalDto getBySpelling(@PathVariable String spelling) {
        Radical radical = radicalService.getBySpelling(spelling);
        return radicalMapper.toDto(radical);
    }

    @GetMapping("/search/sc={strokeCount}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
    public List<RadicalDto> getAllKRadicalByStrokeCount(@PathVariable Integer strokeCount) {
        List<Radical> radicals = radicalService.getAllByStrokeCount(strokeCount);
        return radicals.stream().map(radicalMapper::toDto).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable Long id) {
        radicalService.delete(id);
    }

}
