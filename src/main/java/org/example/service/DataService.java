package org.example.service;

import org.example.model.City;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с городами из файла
 */
public interface DataService {

    /**
     * Получить отсортированный список строковых данных из файла
     * @return Отсортированный строковый список
     */
    List<String> loadAndSortedStringData();

    /**
     * Получить отсортированный список числовый данных из файла
     * @return Отсортированный числовой список
     */
    List<Integer> loadAndSortedIntData();

    /**
     * Получить города из файла с требуемой сортировкой
     *
     * @param clazz Класс с указанием, по какому полю будет проводиться сортировка
     * @return Сортированное множество городов
     * @param <T> Тип сортировки
     */
    <T extends City & Comparable<City>> Set<T> loadSortedCity(Class<T> clazz);

    /**
     * Загрузить в базу данные из файла
     */
    void addCityToRepository();
}
