package com.mmts.algorithm;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=DistanceCalculated.class)
public class DistanceCalculatedTest {

    @MockBean
    DistanceCalculated distanceCalculated;

    @Test
    public void test1()
    {
        Mockito.when(distanceCalculated.calculateDistance(Mockito.anyString(), Mockito.anyString())).thenReturn(50.0);
        assertEquals(50.0, distanceCalculated.calculateDistance("hyb", "fm"), 0);
    }
}
