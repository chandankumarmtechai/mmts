package com.mmts.algorithm;

import org.springframework.stereotype.Service;

@Service
public class PnrGenerated implements PnrGeneration{

    public String generatePnr(String dtime)
    {
        return "1" + dtime;
    }
}
