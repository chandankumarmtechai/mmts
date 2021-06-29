package com.mmts.algorithm;

import com.mmts.dao.FclassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FairCalculated implements FairCalculation{

    @Autowired
    DistanceCalculated distanceCalculated;
    @Autowired
    FclassDao fclassDao;

    @Override
    public double calculateFair(String s_code, String d_code, int noadult, String cname) {
        double distance = distanceCalculated.calculateDistance(s_code, d_code);
        double fair = fclassDao.findByCname(cname).getFair();
        return fair*distance*noadult;
    }
}
