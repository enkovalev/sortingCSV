package org.example.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Город
 */
@Setter
@Getter
public class City {

    /**
     * id
     */
    int id;

    /**
     * Код города
     */
    int code;

    /**
     * Название города
     */
    String name;

    @Override
    public String toString() {
        return "City{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
