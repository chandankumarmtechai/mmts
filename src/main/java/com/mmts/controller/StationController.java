package com.mmts.controller;

import com.mmts.dao.StationDao;
import com.mmts.modal.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class StationController {

    @Autowired
    StationDao stationDao;

    @RequestMapping("/stations")
    public List<Station> getAllStations()
    {
        return stationDao.findAll();
    }

    @RequestMapping("stations/{code}")
    public Station getStation(@PathVariable String code)
    {
        return stationDao.findByCode(code);
    }
}
