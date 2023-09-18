package com.amigoscode.springbootplants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    @Autowired
    PlantRepository db;

    public void addPlant(Plant p){
        db.save(p);
    }
    //
    public List<Plant> getAllPlants(){

        return db.findAll();
    }
    //
    public Plant getPlant(String name){
        return db.findByName(name);
    }
    public List<Plant> getPlantWithText(String text) {
        String str = text.toLowerCase();
        List<Plant> allPlants = db.findAll();
        List<Plant> plants = new ArrayList<>();

        String name = "";
        String watering = "";
        String sunlight = "";

        for(Plant p : allPlants){
            if(p.getName() != null){
                name = p.getName().toLowerCase();
            }
            if(p.getWatering() != null){
                watering = p.getWatering().toLowerCase();
            }
            if(p.getSunlight() != null){
                sunlight = p.getSunlight().toLowerCase();
            }
            if(name.contains(str) || watering.contains(str) || sunlight.contains(str))
                plants.add(p);
        }

        return plants;
    }

    public Optional<Plant> getPlantById(Integer id){
        return db.findById(id);
    }
//    public Optional<Plant> getPlantById(Integer id){
//        Optional<Plant> plant =  db.findById(id);
//
//           if(plant.isPresent()){
//            return plant;
//        }
//
//        return plant;
//    }
    public void updatePlant(Integer id, Plant plant){
        Optional<Plant> plantUpdate =  db.findById(id);

        if (plantUpdate.isPresent()) {
            if (plant.getName() != null) {
                plantUpdate.get().setName(plant.getName());
            }
            if (plant.getWatering() != null) {
                plantUpdate.get().setWatering(plant.getWatering());
            }
            if (plant.getSunlight() != null) {
                plantUpdate.get().setSunlight(plant.getSunlight());
            }
            if(plant.getCareNotes() != null){
                plantUpdate.get().setCareNotes(plant.getCareNotes());
            }
            if(plant.getImage() != null){
                plantUpdate.get().setImage(plant.getImage());
            }
            db.save(plantUpdate.get());
    }

}

public void deleteById(Integer id){
         db.deleteById(id);
}
}
