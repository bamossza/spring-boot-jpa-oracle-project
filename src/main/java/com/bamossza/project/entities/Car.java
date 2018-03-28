package com.bamossza.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="CAR")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final Logger logger = LoggerFactory.getLogger(Car.class);
	
	@Id
	@GeneratedValue(generator = "CAR_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CAR_SEQ", sequenceName = "CAR_SEQ", allocationSize=1)
	@Column(name="CAR_ID", unique=true, nullable=false, precision=10, scale=0)
	private Integer carId;
    
	@Column(name="CAR_BRAND", nullable = true, length = 50)
	private String carBrand;
	
	@Column(name="CAR_MODEL", nullable = true, length = 50)
    private String carModel;
	
	@Column(name="HORSEPOWER", nullable = true, length = 6)
    private String horsepower;
	
	@Column(name="CAR_ENGINE", nullable = true, length = 6)
    private String carEngine;
	
	public Car(){}  
	
    public Car(String carBrand, String carModel, String horsepower, String carEngine) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.horsepower = horsepower;
        this.carEngine = carEngine;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower;
    }

    public String getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(String carEngine) {
        this.carEngine = carEngine;
    }

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

}
