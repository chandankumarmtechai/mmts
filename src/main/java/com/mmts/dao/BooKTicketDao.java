package com.mmts.dao;
import com.mmts.modal.BookTicket;
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

    public BookTicket findByPnr(String pnr)
    {
        return jdbcTemplate.queryForObject("select * from bookticket where pnr = ?",
                new Object[] { pnr }, new BeanPropertyRowMapper<BookTicket>(BookTicket.class));
    }

    public int insert(BookTicket bookTicket)
    {
        return jdbcTemplate.update("insert into bookticket(pnr, s_code, d_code, fair," +
                "dtime, noadult, nochild, cname) values(?,?,?,?,?,?,?,?)", new Object[]
                {bookTicket.getPnr(), bookTicket.getS_code(), bookTicket.getD_code(), bookTicket.getFair(),
                bookTicket.getDtime(), bookTicket.getNoadult(), bookTicket.getNochild(), bookTicket.getCname()});
    }

}
