package com.example.vd.controller;

import com.example.vd.model.City;
import com.example.vd.service.impl.CityServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
@Tag(name = "Controller for working with cities", description = "CRUD operations")
public class CityController {

    private final CityServiceImpl cityService;

    @Operation(summary = "Getting a list of cities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The list is loaded",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @GetMapping
    public Page<City> getAllCities(Pageable pageable) {
        return cityService.getAll(pageable);
    }

    @Operation(summary = "Getting a city by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The city is loaded",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @Operation(summary = "Adding a city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City added",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @PostMapping
    public void addCity(@RequestBody City city) {
        cityService.save(city);
    }

    @Operation(summary = "Updating the city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City updated",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @PutMapping("/{id}")
    public void updateCity(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        cityService.update(city);
    }

    @Operation(summary = "Deleting a city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City deleted",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteById(id);
    }


    @PostMapping("/load")
    public void loadCsvFile(@RequestParam(defaultValue = "rus.csv") String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] array = line.split(",");
                cityService.addFromCsv(array[1], array[2], array[0], array[3]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
