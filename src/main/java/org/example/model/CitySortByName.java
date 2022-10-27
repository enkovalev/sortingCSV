package org.example.model;

public class CitySortByName extends City implements Comparable<City> {

// из за повторений (Aarhus целых 73 раза встречается) пришлось усложнять
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
