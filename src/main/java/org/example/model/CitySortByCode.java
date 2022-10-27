package org.example.model;

import java.math.BigDecimal;

/**
 * Город сортируемый по коду
 */
public class CitySortByCode extends City implements Comparable<City> {

    @Override
    public int compareTo(City city) {
        if (city == null) {
            return -1;
        }
        return getCompareValue(this).compareTo(getCompareValue(city));
    }

    private BigDecimal getCompareValue(City city) {
        return new BigDecimal(city.getCode() + "." + String.format("%05d", city.getId()));
    }
}
