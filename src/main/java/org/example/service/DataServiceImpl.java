package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.City;
import org.example.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {
    private final CityRepository cityRepository;

    private File getInputFile() {
        Path inputPath = Paths.get("src\\main\\resources\\myFile0.csv");
        return new File(inputPath.toUri());
    }

//    a)	Sort the loaded data alphabetically for the string data
    public List<String> loadAndSortedStringData() {
        File inputFile = getInputFile();
        List<String> stringValue = new ArrayList<>();
        try (
                var inputFr = new FileReader(inputFile);
                var inputBr = new BufferedReader(inputFr)
        ) {
            String line = inputBr.readLine();
            line = inputBr.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                stringValue.add(splitLine[1]);
                line = inputBr.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return stringValue.stream().sorted().collect(Collectors.toList());
    }

//    b)	Sort the loaded data numerically for the numeric data
    public List<Integer> loadAndSortedIntData() {
        File inputFile = getInputFile();
        List<Integer> intValue = new ArrayList<>();
        try (
                var inputFr = new FileReader(inputFile);
                var inputBr = new BufferedReader(inputFr)
        ) {
            String line = inputBr.readLine();
            line = inputBr.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");

                // при необходимости можно обрабатывать NumberFormatException
                intValue.add(Integer.parseInt(splitLine[0]));
                line = inputBr.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return intValue.stream().sorted().collect(Collectors.toList());
    }

//    d)	Create data structure that combines both types of data structures
    public <T extends City & Comparable<City>> Set<T> loadSortedCity(Class<T> clazz) {
        File inputFile = getInputFile();
        Set<T> sortedCities = new TreeSet<>();

        try (
                var inputFr = new FileReader(inputFile);
                var inputBr = new BufferedReader(inputFr)
        ) {
            String line = inputBr.readLine();
            line = inputBr.readLine();
            int id = 1;
            while (line != null) {
                String[] splitLine = line.split(",");
                T city = clazz.newInstance();
                city.setId(id);
                city.setCode(Integer.parseInt(splitLine[0]));
                city.setName(splitLine[1]);
                sortedCities.add(city);
                line = inputBr.readLine();
                id++;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sortedCities;
    }

    public void addCityToRepository() {
        File inputFile = getInputFile();
        List<City> cities = new ArrayList<>();
        try (
                var inputFr = new FileReader(inputFile);
                var inputBr = new BufferedReader(inputFr)
        ) {
            String line = inputBr.readLine();
            line = inputBr.readLine();
            while (line != null) {
                String[] splitLine = line.split(",");
                City city = new City();
                city.setCode(Integer.parseInt(splitLine[0]));
                city.setName(splitLine[1]);
                cities.add(city);

                line = inputBr.readLine();
            }
            cityRepository.addCities(cities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
