package org.timvitelli.switchlist.models;

import javax.persistence.*;

@Entity(name = "types")
public class CarType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "car_type")
    private String carType;
    @Column(name = "lading_type")
    private String ladingType;

    public CarType() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getLadingType() {
        return ladingType;
    }

    public void setLadingType(String ladingType) {
        this.ladingType = ladingType;
    }
}
