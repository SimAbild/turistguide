package com.simon.turistguide.controller;

import com.simon.turistguide.model.TouristAttraction;
import com.simon.turistguide.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{name}")
        public ResponseEntity<TouristAttraction> getAttractionByName(
                @PathVariable String name){
        TouristAttraction touristAttraction = touristService.findAttractionByName(name);
        if(touristAttraction == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction newAttraction = touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>(newAttraction, HttpStatus.CREATED);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<ArrayList<TouristAttraction>>deleteAttraction(@PathVariable String name){
        ArrayList<TouristAttraction> removedAttraction = touristService.deleteAttraction(name);
        if(removedAttraction == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(removedAttraction, HttpStatus.OK);
    }

    @PostMapping("/update/")
    public ResponseEntity<ArrayList<TouristAttraction>> updateAttraction(@RequestBody TouristAttraction touristAttraction) {
        ArrayList<TouristAttraction> updatedAttractions = touristService.updateAttraction(touristAttraction);
        return new ResponseEntity<>(updatedAttractions, HttpStatus.OK);
    }
}
