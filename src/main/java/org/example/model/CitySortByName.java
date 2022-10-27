package org.example.model;

/**
 * Город сортируемый по названию
 */
public class CitySortByName extends City implements Comparable<City> {

    @Override
    public int compareTo(City city) {
        if (city == null) {
            return -1;
        }
        return getCompareValue(this).compareTo(getCompareValue(city));
    }

    private String getCompareValue(City city) {
        return city.getName() + "_" + city.getId();
    }
}
