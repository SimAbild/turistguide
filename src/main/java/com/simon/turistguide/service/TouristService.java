package com.simon.turistguide.service;

import com.simon.turistguide.model.TouristAttraction;
import com.simon.turistguide.repository.TouristRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TouristService {
    private final TouristRespository repository;

    public TouristService(TouristRespository repository) {
        this.repository = repository;
    }

    public ArrayList<TouristAttraction> getTouristAttractions() {
        return repository.getTouristAttractions();
    }

    public TouristAttraction findAttractionByName(String name){
       return repository.findAttractionByName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        return repository.addAttraction(touristAttraction);
    }
    public ArrayList<TouristAttraction> deleteAttraction(String name){
        return repository.deleteAttraction(name);
    }

    public TouristAttraction updateAttraction(String name, TouristAttraction touristAttraction) {
        return repository.updateAttraction(name, touristAttraction);
    }
}
