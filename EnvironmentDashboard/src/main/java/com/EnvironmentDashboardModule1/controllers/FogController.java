package com.EnvironmentDashboardModule1.controllers;

import com.EnvironmentDashboardModule1.DTO.CreatingFogDto;
import com.EnvironmentDashboardModule1.DTO.FogDto;
import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.FogBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.MeteoEvents.Fog;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.MeteoEventService;
import com.EnvironmentDashboardModule1.services.FogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;


import java.util.List;

/**
 * Created by Andrei Sfarghiu on 5/13/2017.
 */
@RestController
@RequestMapping("v1/meteoEvents")
public class FogController {

    @Autowired
    private MeteoEventService meteoEventService;

    @Autowired
    private FogService fogService;

    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(value = "/fog", method = RequestMethod.POST)
    public ResponseEntity<Fog> addFog(@RequestBody CreatingFogDto meteoEvent) {
        Fog fog = toCreatingModel(meteoEvent);
        Fog savedMeteoEvent = this.fogService.save(fog);

        EventMapping eventMapping = new EventMapping(savedMeteoEvent.getId(), "Fog");
        eventMappingService.save(eventMapping);

        return new ResponseEntity<>(savedMeteoEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/fog", method = RequestMethod.GET)
    public ResponseEntity<List<FogDto>> getFog() {
        List<Fog> meteoEvents = this.fogService.getAll();
        if (meteoEvents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(meteoEvents, meteoEvent -> toDto(meteoEvent)), HttpStatus.OK);
    }

    @RequestMapping(value = "/fog/{id}", method = RequestMethod.GET)
    public ResponseEntity<FogDto> getFogById(@PathVariable("id") Long id) {
        Fog fog = this.fogService.getById(id);
        if (fog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(fog), HttpStatus.OK);
    }

    @RequestMapping(value = "/fog/{id}", method = RequestMethod.PUT)
    public ResponseEntity<FogDto> updateFog(@PathVariable("id") Long id,@RequestBody CreatingFogDto fogDto){
        Fog fog = toCreatingModel(fogDto);
        Fog fogChecked = this.fogService.getById(id);
        if (fogChecked == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Fog updatedFog= this.fogService.update(fog,id);
        return new ResponseEntity<>(toDto(updatedFog), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/fog", method = RequestMethod.DELETE)
    public ResponseEntity<List<FogDto>> deleteFog(){
        List<Fog> fogList = this.fogService.getAll();

        for(Fog fog : fogList){
            this.fogService.delete(fog.getId());
        }

        return new ResponseEntity<>(Lists.transform(fogList, meteoEvent -> toDto(meteoEvent)), HttpStatus.OK);
    }

    @RequestMapping(value = "fog/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<FogDto> deleteFogById(@PathVariable("id") Long id){
        Fog fog = this.fogService.getById(id);
        if(fog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.meteoEventService.delete(fog.getId());
        return new ResponseEntity<>(toDto(fog), HttpStatus.OK);
    }

    private FogDto toDto(Fog fog) {
        return new FogDto.Builder()
                .name(fog.getName())
                .latitude(fog.getLatitude())
                .longitude(fog.getLongitude())
                .startingDate(fog.getStartingTime())
                .endingDate(fog.getEndingTime())
                .severity(fog.getSeverity())
                .description(fog.getDescription())
                .hints(fog.getHints())
                .radius(fog.getRadius())
                .precipitationLevel(fog.getPrecipitationLevel())
                .temperature(fog.getTemperature())
                .humidity(fog.getHumidity());
    }

    private Fog toCreatingModel(CreatingFogDto dto) {
        return new FogBuilder()
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
                .getFog();
    }


}