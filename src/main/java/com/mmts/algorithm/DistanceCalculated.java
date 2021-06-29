package com.mmts.algorithm;

import com.mmts.dao.RoutesDao;
import com.mmts.modal.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceCalculated implements DistanceCalculation{

    @Autowired
    RouteCalculated routeCalculated;
    @Autowired
    RoutesDao routesDao;
    @Override
    public double calculateDistance(String s_code, String d_code) {
        int route = routeCalculated.calculateCommonRoute(s_code, d_code);
        Routes rs =routesDao.findByCodeAndRouteno(s_code,route);
        Routes ds =routesDao.findByCodeAndRouteno(d_code, route);
        return Math.abs(ds.getDistance() - rs.getDistance());
    }
}
