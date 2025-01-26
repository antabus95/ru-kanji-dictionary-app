package com.example.rukanjidictionaryapp.service.impl;

import com.example.rukanjidictionaryapp.model.Radical;
import com.example.rukanjidictionaryapp.repository.RadicalRepository;
import com.example.rukanjidictionaryapp.service.RadicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RadicalServiceImpl implements RadicalService {

    private final RadicalRepository radicalRepository;

    @Override
    @Transactional(readOnly = true)
    public Radical getById(Long id) {
        return radicalRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Radical not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Radical> getAllByStrokeCount(Integer strokeCount) {
        return radicalRepository.findAllByStrokeCount(strokeCount)
                .orElseThrow(() -> new IllegalStateException("Radical not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Radical getByNumber(Integer number) {
        return radicalRepository.findByNumber(number)
                .orElseThrow(() -> new IllegalStateException("Radical not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Radical> getAll() {
        return radicalRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Radical getBySpelling(String spelling) {
        return radicalRepository.findBySpelling(spelling)
                .orElseThrow(() -> new IllegalStateException("Radical not found"));
    }

    @Override
    @Transactional
    public Radical update(Radical radical) {
        radicalRepository.save(radical);
        return radical;
    }

    @Override
    @Transactional
    public Radical create(Radical radical) {
        if(radicalRepository.findByNumber(radical.getNumber()).isPresent()){
            throw new IllegalStateException("Radical already exists");
        }
        radicalRepository.save(radical);
        return radical;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        radicalRepository.deleteById(id);
    }
}
