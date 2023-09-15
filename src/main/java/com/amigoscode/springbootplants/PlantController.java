package com.amigoscode.springbootplants;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

//@SpringBootApplication
@RestController
// exposes functions with get post put mappings as endpoints clients can call. Method in marked class return json response
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/plants")
public class PlantController {


    @Autowired
    PlantService service;

    @GetMapping()
    public List<Plant> getPlants() {
        return service.getAllPlants();
    }

    @GetMapping("/plants/{name}")
    public Plant getPlant(@PathVariable String name){
        return service.getPlant(name);
    }

    @GetMapping("/plant/{text}")
    public List<Plant> getPlantWithText(@PathVariable String text){
        return service.getPlantWithText(text);
    }

    @PostMapping("/plant")
    public void addPlant(@RequestBody Plant plant) {
        service.addPlant(plant);
    }

    @DeleteMapping("/delete/{plantId}")
    public void deletePlant(@PathVariable("plantId") Integer id) {
        service.deleteById(id);
    }

    @PutMapping("/update/{plantId}")
    public void updatePlant(@PathVariable("plantId") Integer id, @RequestBody Plant plant) {

        service.updatePlant(id, plant);
    }
}

