package com.mmts.algorithm;

import com.mmts.dao.RoutesDao;
import com.mmts.modal.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RouteCalculated implements RouteCalculation{

    @Autowired
    RoutesDao routesDao;

    @Override
    public int calculateCommonRoute(String s_code, String d_code) {
        List<Routes> l1 = routesDao.findRoutesByCode(s_code);
        List<Routes> l2 = routesDao.findRoutesByCode(d_code);
        Set<Integer> set = l1.stream().map(x->x.getRoute_no()).collect(Collectors.toSet());
        set.retainAll(l2.stream().map(x->x.getRoute_no()).collect(Collectors.toSet()));
        List<Integer> list = new ArrayList<>(set);
        return list.get(0);
    }
}
