package com.simon.turistguide.controller;

import com.simon.turistguide.model.TouristAttraction;
import com.simon.turistguide.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("Attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService){
        this.touristService = touristService;
    }

    @GetMapping()
    public ResponseEntity<ArrayList<TouristAttraction>> getAttractions() {
        ArrayList<TouristAttraction> attractions = touristService.getTouristAttractions();
        return new ResponseEntity<>(attractions,HttpStatus.OK);
    }
}
//ændring