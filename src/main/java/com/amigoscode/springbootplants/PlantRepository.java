package com.amigoscode.springbootplants;

import org.springframework.data.jpa.repository.JpaRepository;

//Integer because this is the datatype for customer ID
public interface PlantRepository extends JpaRepository<Plant, Integer> {
    Plant findByName(String name);
    Plant findById(int id);
}
