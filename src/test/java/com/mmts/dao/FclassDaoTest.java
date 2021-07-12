package com.mmts.dao;

import com.mmts.mmts.MmtsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes=MmtsApplication.class)
@SpringBootTest(classes=MmtsApplication.class)
public class FclassDaoTest {

    //FclassDao fclassDao = new FclassDao(new JdbcTemplate());
    @Autowired
    FclassDao fclassDao;
    @Test
    public void test1()
    {
        assertEquals(10.0,fclassDao.findByCname("first").getFair(),0);
        assertTrue(true);
    }
}
