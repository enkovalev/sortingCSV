package org.example;

import lombok.RequiredArgsConstructor;
import org.example.model.City;
import org.example.repository.CityRepository;
import org.example.service.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CityController {
    private final DataService dataService;
    private final CityRepository cityRepository;

    @PostMapping(value = "/cities")
    public ResponseEntity<?> create() {
        dataService.addCityToRepository();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/city-sorted-by-name")
    public ResponseEntity<List<City>> getSortedCityByName() {
        final List<City> cities = cityRepository.getSortedCityByName();

        return cities != null
                ? new ResponseEntity<>(cities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/city-sorted-by-code")
    public ResponseEntity<List<City>> getSortedCityByCode() {
        final List<City> cities = cityRepository.getSortedCityByCode();

        return cities != null
                ? new ResponseEntity<>(cities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
