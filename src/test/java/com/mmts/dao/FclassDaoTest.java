package com.mmts.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FclassDaoTest {

    FclassDao fclassDao = new FclassDao(new JdbcTemplate());

    @Test
    public void test1()
    {
        assertEquals(10.0,fclassDao.findByCname("first").getFair());
    }
}
