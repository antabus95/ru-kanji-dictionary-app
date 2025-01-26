package com.example.rukanjidictionaryapp.service;

import com.example.rukanjidictionaryapp.model.Radical;

import java.util.List;

public interface RadicalService {

    Radical getById(Long id);

    List<Radical> getAllByStrokeCount(Integer strokeCount);

    Radical getByNumber(Integer number);

    List<Radical> getAll();

    Radical getBySpelling(String spelling);

    Radical update(Radical radical);

    Radical create(Radical radical);

    void delete(Long id);

}
