package com.rest.project.SpringRestProject.services;

import com.rest.project.SpringRestProject.exceptions.NotCreatedException;
import com.rest.project.SpringRestProject.exceptions.NotFoundException;
import com.rest.project.SpringRestProject.models.Sensor;
import com.rest.project.SpringRestProject.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public Sensor findOne(int id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sensor with id: " + id + " - not found"));
    }

    @Transactional
    public void save(Sensor sensor) {

        if (sensorRepository.findByName(sensor.getName()).isPresent()) {
            throw new NotCreatedException("Sensor with this name: " + sensor.getName() + " - already exists");
        }

        sensorRepository.save(sensor);
    }
}
