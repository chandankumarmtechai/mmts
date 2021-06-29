package com.mmts.dao;

import com.mmts.modal.Fclass;
import com.mmts.modal.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FclassDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public FclassDao()
    {}

    public FclassDao(JdbcTemplate jdbcTemplate)
    { this.jdbcTemplate = jdbcTemplate; }

    public List<Fclass> findAll()
    {
        return jdbcTemplate.query("select * from class", new BeanPropertyRowMapper<Fclass>(Fclass.class));

    }

    public Fclass findByCname(String cname)
    {
        return jdbcTemplate.queryForObject("select * from class where name = ?", new Object[] {cname},
                new BeanPropertyRowMapper<Fclass>(Fclass.class));
    }

    public int insert(Fclass fclass)
    {
        return jdbcTemplate.update("insert into class(name, fair) values(?,?)", new Object[]
                {fclass.getName(), fclass.getFair()});
    }
}
