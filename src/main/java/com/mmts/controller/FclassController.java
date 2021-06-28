package com.mmts.controller;

import com.mmts.dao.FclassDao;
import com.mmts.modal.Fclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FclassController {

    @Autowired
    FclassDao fclassDao;

    @RequestMapping("/classes")
    public List<Fclass> getAllClasse()
    {
        return fclassDao.findAll();
    }
    @RequestMapping(method= RequestMethod.POST, value="/classes")
    public int addClass(@RequestBody Fclass fclass)
    {
        return fclassDao.insert(fclass);
    }
}
