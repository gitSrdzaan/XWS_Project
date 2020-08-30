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
import xws.microservis.rentservice.services.RentAdvertService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/chart")
public class ChartController {

    @Autowired
    private ChartService chartService;

    @Autowired
    private RentAdvertService rentAdvertService;

    @GetMapping(value = "/allCharts")
    public ResponseEntity<?> getAll(){
        ArrayList<Chart> chartArrayList = chartService.getAllCharts();
        return new ResponseEntity<>(chartArrayList,HttpStatus.OK);

    }

    @GetMapping(value = "/getAdverts/{chartId}",produces = "application/json")
    public ResponseEntity<?> getAllRentAdverts(@PathVariable Long chartId){
        Chart chart = chartService.getChart(chartId);
        if(chart == null){
            return  new ResponseEntity<>("Greska pri listanju korpe", HttpStatus.BAD_REQUEST);
        }
        ArrayList<RentAdvert> rentAdvertList = (ArrayList<RentAdvert>) chart.getRentAdvertList();

        return new ResponseEntity<>(rentAdvertList, HttpStatus.OK);

    }

    @PostMapping(value = "/new", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addNewChart(@RequestBody Chart chart){
        try{
            chartService.addChart(chart);
        }
        catch (Exception e){
            return  new ResponseEntity<>("Greska pri stvaranju korpe",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);


    }

    @PutMapping(value = "/add/{chartID}",  produces = "application/json", consumes = "application/json" )
    public ResponseEntity<?> addTOChartNewAdvert(@RequestBody RentAdvert ra,@PathVariable Long chartID){

        Chart chart = chartService.getChart(chartID);
        if(chart == null){

            chart = new Chart();
        }
        RentAdvert temp = rentAdvertService.findRentAdvert(ra.getId());
        if(temp == null){

        }

        chart.getRentAdvertList().add(temp);
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
