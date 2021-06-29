package com.mmts.dao;

import com.mmts.modal.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoutesDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Routes> findRoutesByCode(String code)
    {
        return jdbcTemplate.query("select * from routes where code =?", new Object[] {code},
                new BeanPropertyRowMapper<Routes>(Routes.class));
    }

    public Routes findByCodeAndRouteno(String code, int route_no)
    {
        return jdbcTemplate.queryForObject("select * from routes where code = ? and route_no = ?",
                new Object[] {code, route_no}, new BeanPropertyRowMapper<Routes>(Routes.class));
    }
}
