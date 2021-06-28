package com.mmts.controller;

import com.mmts.dao.RouteDao;
import com.mmts.modal.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteController {

    @Autowired
    RouteDao routeDao;

    @RequestMapping("/routes")
    public List<Route> getAllRoutes()
    {
        return routeDao.findAll();
    }
}
