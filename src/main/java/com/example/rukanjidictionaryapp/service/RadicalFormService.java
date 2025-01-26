package com.example.rukanjidictionaryapp.service;

import com.example.rukanjidictionaryapp.model.RadicalForm;

public interface RadicalFormService {

    RadicalForm getById(Long id);

    RadicalForm create(RadicalForm radicalForm);

    RadicalForm update(RadicalForm radicalForm);

}
