/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtn.formatter;

import com.dtn.pojo.Station;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Nguyen0210
 */
public class StationFormatter implements Formatter<Station> {

    @Override
    public String print(Station station, Locale locale) {
         return String.valueOf(station.getId());
    }

    @Override
    public Station parse(String stationId, Locale locale) throws ParseException {
         Station s = new Station();
        s.setId(Integer.parseInt(stationId));
        
        return s;
    }
    
}
