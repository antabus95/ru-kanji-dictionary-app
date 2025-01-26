package com.example.rukanjidictionaryapp.service.impl;

import com.example.rukanjidictionaryapp.model.RadicalForm;
import com.example.rukanjidictionaryapp.repository.RadicalFormRepository;
import com.example.rukanjidictionaryapp.service.RadicalFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RadicalFormServiceImpl implements RadicalFormService {

    private final RadicalFormRepository radicalFormRepository;

    @Override
    @Transactional(readOnly = true)
    public RadicalForm getById(Long id) {
        return radicalFormRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Radical form not found"));
    }

    @Override
    @Transactional
    public RadicalForm create(RadicalForm radicalForm) {
        if((radicalFormRepository.findBySpelling(radicalForm.getSpelling()).isPresent())
                || (radicalFormRepository.findBySpelling(radicalForm.getAltSpelling()).isPresent())){
            throw new IllegalStateException("Radical form already exists");
        }
        radicalFormRepository.save(radicalForm);
        return radicalForm;
    }

    @Override
    @Transactional
    public RadicalForm update(RadicalForm radicalForm) {
        radicalFormRepository.save(radicalForm);
        return radicalForm;
    }
}
