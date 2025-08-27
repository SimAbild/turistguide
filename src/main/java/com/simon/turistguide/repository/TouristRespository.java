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

    public TouristAttraction findAttractionByName(String name){
        for (TouristAttraction touristAttraction : touristAttractions){
            if (touristAttraction.getName().equals(name)){
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);
        return touristAttraction;
    }

    public ArrayList<TouristAttraction> deleteAttraction(String name){
        for(TouristAttraction touristAttraction : touristAttractions){
            if(name.equals(touristAttraction.getName())){
                touristAttractions.remove(touristAttraction);
            }
        }
        return touristAttractions;
    }

    public TouristAttraction updateAttraction(String name, TouristAttraction touristAttraction) {
        TouristAttraction attraction = findAttractionByName(name);
        attraction.setName(touristAttraction.getName());
        attraction.setDescription(touristAttraction.getDescription());
        return attraction;
    }
}
