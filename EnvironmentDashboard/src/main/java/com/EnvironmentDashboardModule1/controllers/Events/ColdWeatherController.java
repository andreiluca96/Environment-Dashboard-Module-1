package com.EnvironmentDashboardModule1.controllers.Events;

import com.EnvironmentDashboardModule1.DTO.CreatingColdWeatherDto;
import com.EnvironmentDashboardModule1.DTO.ColdWeatherDto;
import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.ColdWeatherBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.MeteoEvents.ColdWeather;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.MeteoEventService;
import com.EnvironmentDashboardModule1.services.ColdWeatherService;
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
public class ColdWeatherController {

    @Autowired
    private MeteoEventService meteoEventService;

    @Autowired
    private ColdWeatherService coldWeatherService;

    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(value = "/coldWeather", method = RequestMethod.POST)
    public ResponseEntity<ColdWeather> addColdWeather(@RequestBody CreatingColdWeatherDto meteoEvent) {
        ColdWeather coldWeather = toCreatingModel(meteoEvent);
        ColdWeather savedMeteoEvent = this.coldWeatherService.save(coldWeather);
        if(coldWeather==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventMapping eventMapping = new EventMapping(savedMeteoEvent.getId(), "ColdWeather");
        eventMappingService.save(eventMapping);

        return new ResponseEntity<>(savedMeteoEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/coldWeather", method = RequestMethod.GET)
    public ResponseEntity<List<ColdWeatherDto>> getColdWeather() {
        List<ColdWeather> meteoEvents = this.coldWeatherService.getAll();
        if (meteoEvents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(meteoEvents, meteoEvent -> toDto(meteoEvent)), HttpStatus.OK);
    }

    @RequestMapping(value = "/coldWeather/{id}", method = RequestMethod.GET)
    public ResponseEntity<ColdWeatherDto> getColdWeatherById(@PathVariable("id") Long id) {
        ColdWeather coldWeather = this.coldWeatherService.getById(id);
        if (coldWeather == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(coldWeather), HttpStatus.OK);
    }

    @RequestMapping(value = "/coldWeather/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ColdWeatherDto> updateColdWeather(@PathVariable("id") Long id,@RequestBody CreatingColdWeatherDto coldWeatherDto){
        ColdWeather coldWeather = toCreatingModel(coldWeatherDto);
        ColdWeather coldWeatherChecked = this.coldWeatherService.getById(id);
        if (coldWeatherChecked == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ColdWeather updatedColdWeather= this.coldWeatherService.update(coldWeather,id);
        return new ResponseEntity<>(toDto(updatedColdWeather), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/coldWeather", method = RequestMethod.DELETE)
    public ResponseEntity<List<ColdWeatherDto>> deleteColdWeather(){
        List<ColdWeather> coldWeatherList = this.coldWeatherService.getAll();
    if(coldWeatherList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
        for(ColdWeather coldWeather : coldWeatherList){
            this.coldWeatherService.delete(coldWeather.getId());
        }

        return new ResponseEntity<>(Lists.transform(coldWeatherList, meteoEvent -> toDto(meteoEvent)), HttpStatus.OK);
    }

    @RequestMapping(value = "coldWeather/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ColdWeatherDto> deleteColdWeatherById(@PathVariable("id") Long id){
        ColdWeather coldWeather = this.coldWeatherService.getById(id);
        if(coldWeather == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.meteoEventService.delete(coldWeather.getId());
        return new ResponseEntity<>(toDto(coldWeather), HttpStatus.OK);
    }

    private ColdWeatherDto toDto(ColdWeather coldWeather) {
        return new ColdWeatherDto.Builder()
                .id(coldWeather.getId())
                .name(coldWeather.getName())
                .latitude(coldWeather.getLatitude())
                .longitude(coldWeather.getLongitude())
                .startingDate(coldWeather.getStartingTime())
                .endingDate(coldWeather.getEndingTime())
                .severity(coldWeather.getSeverity())
                .description(coldWeather.getDescription())
                .hints(coldWeather.getHints())
                .radius(coldWeather.getRadius())
                .precipitationLevel(coldWeather.getPrecipitationLevel())
                .temperature(coldWeather.getTemperature())
                .humidity(coldWeather.getHumidity());
    }

    private ColdWeather toCreatingModel(CreatingColdWeatherDto dto) {
        return new ColdWeatherBuilder()
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLatitude())
                .setDescription(dto.getDescription())
                .setEndingTime(dto.getEndingDate())
                .setStartingTime(dto.getStartingDate())
                .setHints(dto.getHints())
                .setRadius(dto.getRadius())
                .setSeverity(dto.getSeverity())
                .setHumidity(dto.getHumidity())
                .setPrecipitationLevel(dto.getPrecipitationLevel())
                .setTemperature(dto.getTemperature())
                .getColdWeather();
    }


}