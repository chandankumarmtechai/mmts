package com.mmts.controller;

import com.mmts.algorithm.FairCalculated;
import com.mmts.algorithm.PnrGenerated;
import com.mmts.dao.BooKTicketDao;
import com.mmts.modal.BookTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class BookTicketController {

    @Autowired
    BooKTicketDao booKTicketDao;
    @Autowired
    FairCalculated fairCalculated;
    @Autowired
    PnrGenerated pnrGenerated;

    @RequestMapping("/booktickets")
    public List<BookTicket> getAllBookTickets()
    {
        return booKTicketDao.findAll();
    }

    @RequestMapping("/booktickets/{pnr}")
    public BookTicket getBookTicket(@PathVariable String pnr)
    {
        return booKTicketDao.findByPnr(pnr);
    }

    @RequestMapping(method= RequestMethod.POST, value="/booktickets")
    public BookTicket addBookTicket(@RequestBody BookTicket bookTicket)
    {
        bookTicket.setFair(fairCalculated.calculateFair(bookTicket.getS_code(),bookTicket.getD_code(),
        bookTicket.getNoadult(),bookTicket.getCname()));

        bookTicket.setDtime(LocalDateTime.now());
        bookTicket.setPnr(pnrGenerated.generatePnr(bookTicket.getDtime().toString()));

        booKTicketDao.insert(bookTicket);
        return bookTicket;
    }
}
