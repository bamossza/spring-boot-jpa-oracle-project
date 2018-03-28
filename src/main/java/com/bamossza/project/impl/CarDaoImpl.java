package com.bamossza.project.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bamossza.project.dao.CarDao;
import com.bamossza.project.entities.Car;
import com.bamossza.project.repository.CarRepository;

@Repository
public class CarDaoImpl implements CarDao {

	private static final Logger logger = LoggerFactory.getLogger(CarDaoImpl.class);
	
	@Autowired
	private CarRepository carRepository;
	
    public CarDaoImpl() {
    	
    }

    @Override
    public Car findById(int id) {
    	
    	try {
            return carRepository.findByCarId(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    	return null;
    }

    @Override
    public void remove(int id) {
    	try {
    		Car car = new Car();
    		car.setCarId(id);
    		carRepository.delete(car);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Override
    public void add(Car car) {
    	try {
    		carRepository.save(car);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Override
    public void update(int id, Car car) {
    	try {
    		car.setCarId(id);
    		carRepository.save(car);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Override
    public List<Map<String, Object>> findAll() {
    	try {
    		List<Map<String, Object>> list = new ArrayList<>();
        	Map<String, Object> map = new HashMap<>();
        	List<Car> result = carRepository.findAll();
            for (Car car : result) {
            	map = new HashMap<>();
            	map.put(car.getCarId().toString(), car);
            	list.add(map);
            }
            return list;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    	return null;
    }

}
