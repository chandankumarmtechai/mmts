package com.mmts.dao;

import com.mmts.modal.BookTicket;
import com.mmts.modal.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooKTicketDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BookTicket> findAll()
    {
        return jdbcTemplate.query("select * from bookticket", new BeanPropertyRowMapper<BookTicket>(BookTicket.class));
    }

}
