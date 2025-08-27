package com.simon.turistguide.repository;

import com.simon.turistguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TouristRespository {
    private final ArrayList<TouristAttraction> touristAttractions = new ArrayList<>();


    public TouristRespository(){
        populateTouristAttractionList();
    }

    public void populateTouristAttractionList(){
        touristAttractions.add(new TouristAttraction("Tivoli","Forlystelsespark i KBH centrum"));
        touristAttractions.add(new TouristAttraction("Bakken","Der er altid noget om snakken, der er sjovt på Bakken"));
        touristAttractions.add(new TouristAttraction("Faarup","Der er altid noget sjov, ude i en skov"));
        touristAttractions.add(new TouristAttraction("Legoland","Leg godt"));
        touristAttractions.add(new TouristAttraction("BonBon land","Der er skideskægt i BonBon land"));
    }

    public ArrayList<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }
}
