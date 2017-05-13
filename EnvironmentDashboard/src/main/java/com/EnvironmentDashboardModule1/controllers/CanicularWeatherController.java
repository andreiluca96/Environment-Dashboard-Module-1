package com.EnvironmentDashboardModule1.controllers;

import com.EnvironmentDashboardModule1.DTO.CreatingCanicularWeatherDto;
import com.EnvironmentDashboardModule1.DTO.CanicularWeatherDto;
import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.CanicularWeatherBuilder;
import com.EnvironmentDashboardModule1.models.MeteoEvents.CanicularWeather;
import com.EnvironmentDashboardModule1.services.MeteoEventService;
import com.EnvironmentDashboardModule1.services.CanicularWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;


import java.util.List;

/**
 * Created by Radu Lungu on 5/13/2017.
 */
@RestController
@RequestMapping("v1/meteoEvents")
public class CanicularWeatherController {

    @Autowired
    private MeteoEventService meteoEventService;

    @Autowired
    private CanicularWeatherService canicularWeatherService;

    @RequestMapping(value = "/canicularWeather", method = RequestMethod.POST)
    public ResponseEntity<CanicularWeather> addCanicularWeather(@RequestBody CreatingCanicularWeatherDto meteoEvent) {
        CanicularWeather canicularWeather = toCreatingModel(meteoEvent);
        CanicularWeather savedMeteoEvent = this.canicularWeatherService.save(canicularWeather);

        return new ResponseEntity<>(savedMeteoEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/canicularWeather", method = RequestMethod.GET)
    public ResponseEntity<List<CanicularWeatherDto>> getCanicularWeather() {
        List<CanicularWeather> meteoEvents = this.canicularWeatherService.getAll();
        if (meteoEvents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(meteoEvents, meteoEvent -> toDto(meteoEvent)), HttpStatus.OK);
    }

    @RequestMapping(value = "/canicularWeather/{id}", method = RequestMethod.GET)
    public ResponseEntity<CanicularWeatherDto> getCanicularWeatherById(@PathVariable("id") Long id) {
        CanicularWeather canicularWeather = this.canicularWeatherService.getById(id);
        if (canicularWeather == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(canicularWeather), HttpStatus.OK);
    }

    @RequestMapping(value = "/canicularWeather/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CanicularWeatherDto> updateCanicularWeather(@PathVariable("id") Long id,@RequestBody CreatingCanicularWeatherDto canicularWeatherDto){
        CanicularWeather canicularWeather = toCreatingModel(canicularWeatherDto);
        CanicularWeather canicularWeatherChecked = this.canicularWeatherService.getById(id);
        if (canicularWeatherChecked == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CanicularWeather updatedCanicularWeather= this.canicularWeatherService.update(canicularWeather,id);
        return new ResponseEntity<>(toDto(updatedCanicularWeather), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/canicularWeather", method = RequestMethod.DELETE)
    public ResponseEntity<List<CanicularWeatherDto>> deleteCanicularWeather(){
        List<CanicularWeather> canicularWeatherList = this.canicularWeatherService.getAll();

        for(CanicularWeather canicularWeather : canicularWeatherList){
            this.canicularWeatherService.delete(canicularWeather.getId());
        }

        return new ResponseEntity<>(Lists.transform(canicularWeatherList, meteoEvent -> toDto(meteoEvent)), HttpStatus.OK);
    }

    @RequestMapping(value = "canicularWeather/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CanicularWeatherDto> deleteCanicularWeatherById(@PathVariable("id") Long id){
        CanicularWeather canicularWeather = this.canicularWeatherService.getById(id);
        if(canicularWeather == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.meteoEventService.delete(canicularWeather.getId());
        return new ResponseEntity<>(toDto(canicularWeather), HttpStatus.OK);
    }

    private CanicularWeatherDto toDto(CanicularWeather canicularWeather) {
        return new CanicularWeatherDto.Builder()
                .name(canicularWeather.getName())
                .latitude(canicularWeather.getLatitude())
                .longitude(canicularWeather.getLongitude())
                .startingDate(canicularWeather.getStartingTime())
                .endingDate(canicularWeather.getEndingTime())
                .severity(canicularWeather.getSeverity())
                .description(canicularWeather.getDescription())
                .hints(canicularWeather.getHints())
                .radius(canicularWeather.getRadius())
                .precipitationLevel(canicularWeather.getPrecipitationLevel())
                .temperature(canicularWeather.getTemperature())
                .humidity(canicularWeather.getHumidity());
    }

    private CanicularWeather toCreatingModel(CreatingCanicularWeatherDto dto) {
        return new CanicularWeatherBuilder()
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLongitude())
                .setDescription(dto.getDescription())
                .setEndingTime(dto.getEndingDate())
                .setStartingTime(dto.getStartingDate())
                .setHints(dto.getHints())
                .setRadius(dto.getRadius())
                .setSeverity(dto.getSeverity())
                .setHumidity(dto.getHumidity())
                .setPrecipitationLevel(dto.getPrecipitationLevel())
                .setTemperature(dto.getTemperature())
                .getCanicularWeather();
    }


}