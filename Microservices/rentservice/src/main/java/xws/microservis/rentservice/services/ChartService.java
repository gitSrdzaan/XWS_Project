package xws.microservis.rentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xws.microservis.rentservice.model.Chart;
import xws.microservis.rentservice.repository.ChartRepository;

import java.util.ArrayList;

@Service
public class ChartService {

    @Autowired
    private ChartRepository repository;

    public Chart getChart(Long id){
        return repository.findById(id).orElse(null);
    }

    public void addChart(Chart chart) throws Exception{
        try{
            repository.save(chart);
        }
        catch (Exception e){
            throw  new Exception("Greska pri kreiranju korpe");
        }


    }

    public void saveChart(Chart chart) throws  Exception {
        try{
            repository.save(chart);
        }
        catch (Exception e){
            e.printStackTrace();
            throw  new Exception("Korpa nije modifikovana");
        }
    }

    public ArrayList<Chart> getAllCharts() {
        return (ArrayList<Chart>) repository.findAll();
    }
}

