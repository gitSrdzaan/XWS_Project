package xws.microservis.rentservice.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xws.microservis.rentservice.model.Chart;
import xws.microservis.rentservice.model.RentAdvert;
import xws.microservis.rentservice.services.ChartService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/korpa")
public class ChartController {

    @Autowired
    private ChartService chartService;

    @GetMapping(value = "/izlistaj/{chartId}")
    public ResponseEntity<?> getAllRentAdverts(@PathVariable Long chartId){
        Chart chart = chartService.getChart(chartId);
        if(chart == null){
            return  new ResponseEntity<>("Greska pri listanju korpe", HttpStatus.BAD_REQUEST);
        }
        ArrayList<RentAdvert> rentAdvertList = (ArrayList<RentAdvert>) chart.getRentAdvertList();

        return new ResponseEntity<>(rentAdvertList, HttpStatus.OK);

    }

    @PostMapping(value = "/nova", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addNewChart(@RequestBody Chart chart){
        try{
            chartService.addChart(chart);
        }
        catch (Exception e){
            return  new ResponseEntity<>("Greska pri stvaranju korpe",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);


    }

    @PutMapping(value = "/dodaj/{chartID}",  produces = "application/json", consumes = "application/json" )
    public ResponseEntity<?> addTOChartNewAdvert(@RequestBody RentAdvert ra,@PathVariable Long chartID){
        Chart chart = chartService.getChart(chartID);
        chart.getRentAdvertList().add(ra);
        try{
            chartService.saveChart(chart);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Greska pri dodavanju u korpu", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<>(HttpStatus.OK);


    }

}