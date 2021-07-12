package com.mmts.controller;

import com.mmts.dao.FclassDao;
import com.mmts.modal.Fclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
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
