package com.mmts.algorithm;

import com.mmts.mmts.MmtsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= MmtsApplication.class)
public class DistanceCalculatedIntegrationTest {

    @Autowired
    DistanceCalculated distanceCalculated;

    @Test
    public void test1()
    {
        assertEquals(21.0, distanceCalculated.calculateDistance("lpi", "fm"), 0);
    }
}
