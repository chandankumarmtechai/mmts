package com.mmts.dao;

import com.mmts.modal.Route;
import com.mmts.modal.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Route> findAll()
    {
        return jdbcTemplate.query("select * from route", new BeanPropertyRowMapper<Route>(Route.class));
    }
}
