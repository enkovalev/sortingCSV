package org.example.model;

import java.math.BigDecimal;

public class CitySortByCode extends City implements Comparable<City> {

// city_code тоже повторяются
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
