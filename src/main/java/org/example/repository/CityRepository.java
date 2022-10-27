package org.example.repository;

import org.example.model.City;

import java.util.List;

/**
 * Сервис работы с репозиторием
 */
public interface CityRepository {

    /**
     * Загрузить все города
     * @param cities Список городов
     */
    void addCities(List<City> cities);

    /**
     * Получить отсортированный список по названию
     * @return Осортированный список городов
     */
    List<City> getSortedCityByName();

    /**
     * Получить отсортированный список по коду
     * @return Осортированный список городов
     */
    List<City> getSortedCityByCode();
}
