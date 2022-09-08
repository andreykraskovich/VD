package com.example.vd.service.impl;

import com.example.vd.exception.ObjectNotFoundException;
import com.example.vd.model.City;
import com.example.vd.repository.CityRepository;
import com.example.vd.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public Page<City> getAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public City findById(Long id) {
        City city = cityRepository
                .findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("City with id: " + id + " not found")
                );
        return city;
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void update(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void addFromCsv(String name, String countryCode, String district, String population) {
        City city = new City();
        city.setCountryCode(countryCode);
        city.setName(name);
        city.setDistrict(district);
        city.setPopulation(population);
        cityRepository.save(city);
    }

}
