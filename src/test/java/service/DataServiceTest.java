package service;

import org.example.model.CitySortByCode;
import org.example.model.CitySortByName;
import org.example.repository.CityRepository;
import org.example.service.DataServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class DataServiceTest {

    DataServiceImpl dataService = new DataServiceImpl(mock(CityRepository.class));

    // c)	Write the unit test that prints the a) and b)
    @Test
    void loadStringDataTest() {
        System.out.println("a)\tSort the loaded data alphabetically for the string data");
        System.out.println(dataService.loadAndSortedStringData());
        assertEquals(50000, dataService.loadAndSortedStringData().size());
    }

    @Test
    void loadIntDataTest() {
        System.out.println("b)\tSort the loaded data numerically for the numeric data ");
        System.out.println(dataService.loadAndSortedIntData());
        assertEquals(50000, dataService.loadAndSortedIntData().size());
    }

//    e)	Write the unit test similar to c)
    @Test
    void sortByNameTest() {
        Set<CitySortByName> citiesSortByName = dataService.loadSortedCity(CitySortByName.class);
        System.out.println("CitySortByName");
        System.out.println(citiesSortByName);
        assertEquals(50000, citiesSortByName.size());
    }

    @Test
    void sortByCodeTest() {
        Set<CitySortByCode> citiesSortByCode = dataService.loadSortedCity(CitySortByCode.class);
        System.out.println("CitySortByCode");
        System.out.println(citiesSortByCode);
        assertEquals(50000, citiesSortByCode.size());
    }
}
