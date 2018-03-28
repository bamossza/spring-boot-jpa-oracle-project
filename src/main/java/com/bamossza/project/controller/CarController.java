package com.bamossza.project.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bamossza.project.entities.Car;
import com.bamossza.project.service.CarService;

@RestController
@RequestMapping(value = "/api/cars")
public class CarController {

	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	CarService carService;

	@Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
	
	@RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Car car) {
        try {
        	logger.info(car.getCarBrand());
        	logger.info(car.getCarEngine());
        	logger.info(car.getCarModel());
        	logger.info(car.getHorsepower());
            carService.add(car);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        try {
        	List<Map<String, Object>> result = carService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Car> getById(@PathVariable("id") int id) {
        try {
            Car car = carService.findById(id);
            if (car != null) {
                return ResponseEntity.status(HttpStatus.OK).body(car);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Car car) {
        try {
            carService.update(id, car);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        try {
            carService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
