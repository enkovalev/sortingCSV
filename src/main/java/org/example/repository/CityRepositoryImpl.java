package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.model.City;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CityRepositoryImpl implements CityRepository {
    private static final String INSERT_CITIES = "insert into city (code, name) values (?, ?)";
    private static final String SELECT_SORTED_BY_NAME = "SELECT * FROM city ORDER BY name";
    private static final String SELECT_SORTED_BY_CODE = "SELECT * FROM city ORDER BY code";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void addCities(List<City> cities) {
        jdbcTemplate.batchUpdate(INSERT_CITIES, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, cities.get(i).getCode());
                ps.setString(2, cities.get(i).getName());
            }

            @Override
            public int getBatchSize() {
                return cities.size();
            }
        });
    }

    @Override
    public List<City> getSortedCityByName() {
        return jdbcTemplate.query(SELECT_SORTED_BY_NAME, new BeanPropertyRowMapper<>(City.class));
    }

    @Override
    public List<City> getSortedCityByCode() {
        return jdbcTemplate.query(SELECT_SORTED_BY_CODE, new BeanPropertyRowMapper<>(City.class));
    }


}
