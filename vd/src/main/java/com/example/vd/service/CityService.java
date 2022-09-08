package com.example.vd.service;

import com.example.vd.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {

    Page<City> getAll(Pageable pageable);

    City findById(Long id);

    void save(City city);

    void update(City city);

    void deleteById(Long id);

    void addFromCsv(String name, String countryCode, String district, String population);
}
