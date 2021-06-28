package com.mmts.dao;

import com.mmts.modal.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StationDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Station> findAll()
    {
        return jdbcTemplate.query("select * from station", new BeanPropertyRowMapper<Station>(Station.class));
    }

    public Station findByCode(String code)
    {
        return jdbcTemplate.queryForObject("select * from station where code = ?"
        , new Object[] { code }, new BeanPropertyRowMapper<Station>(Station.class));
    }
}
