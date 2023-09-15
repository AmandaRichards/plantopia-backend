package com.amigoscode.springbootplants;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Plant {
    @Id  //sets primary key in table
    @SequenceGenerator(
            name = "plant_id_sequence",
            sequenceName = "plant_id_sequence",
            allocationSize = 1 //sets how much each ID will increment by
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plant_id_sequence"
    )
    private Integer id;
    private String name;
    private String watering;
    private String sunlight;
    private String careNotes;
    private String image;

    public String getCareNotes() {
        return careNotes;
    }

    public void setCareNotes(String careNotes) {
        this.careNotes = careNotes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Plant(Integer id, String name, String watering, String sunlight) {
        this.id = id;
        this.name = name;
        this.watering = watering;
        this.sunlight = sunlight;
    }

    public Plant() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return Objects.equals(id, plant.id) && Objects.equals(name, plant.name) && Objects.equals(watering, plant.watering) && Objects.equals(sunlight, plant.sunlight) && Objects.equals(careNotes, plant.careNotes) && Objects.equals(image, plant.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, watering, sunlight, careNotes, image);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", watering='" + watering + '\'' +
                ", sunlight='" + sunlight + '\'' +
                ", careNotes='" + careNotes + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public String getSunlight() {
        return sunlight;
    }

    public void setSunlight(String sunlight) {
        this.sunlight = sunlight;
    }

}

//jakarta persistence replaced java persistence