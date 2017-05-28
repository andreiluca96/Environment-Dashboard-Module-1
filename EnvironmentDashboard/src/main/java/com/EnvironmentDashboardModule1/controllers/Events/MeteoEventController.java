package com.EnvironmentDashboardModule1.controllers.Events;

import com.EnvironmentDashboardModule1.DTO.CreatingMeteoEventDto;
import com.EnvironmentDashboardModule1.DTO.MeteoEventDto;
import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.MeteoEventBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.MeteoEvents.MeteoEvent;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.MeteoEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;


import java.util.List;

/**
 * Created by Ariana on 5/13/2017.
 */
@RestController
@RequestMapping("v1/events")
public class MeteoEventController {

    @Autowired
    private MeteoEventService meteoEventService;

    @Autowired
    private EventService eventService;

    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(value = "/meteoevent", method = RequestMethod.POST)
    public ResponseEntity<MeteoEvent> addMeteoEvent(@RequestBody CreatingMeteoEventDto event) {
        MeteoEvent meteoEvent = toCreatingModel(event);
        MeteoEvent savedMeteoEvent = this.meteoEventService.save(meteoEvent);
        if(meteoEvent==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventMapping eventMapping = new EventMapping(savedMeteoEvent.getId(), "MeteoEvent");
        eventMappingService.save(eventMapping);
        

        return new ResponseEntity<>(savedMeteoEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/meteoevent", method = RequestMethod.GET)
    public ResponseEntity<List<MeteoEventDto>> getMeteoEvent() {
        List<MeteoEvent> events = this.meteoEventService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/meteoevent/{id}", method = RequestMethod.GET)
    public ResponseEntity<MeteoEventDto> getMeteoEventById(@PathVariable("id") Long id) {
        MeteoEvent meteoEvent = this.meteoEventService.getById(id);
        if (meteoEvent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(meteoEvent), HttpStatus.OK);
    }

    @RequestMapping(value = "/meteoevent/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MeteoEventDto> updateMeteoEvent(@PathVariable("id") Long id,@RequestBody CreatingMeteoEventDto meteoEventDto){
        MeteoEvent meteoEvent = toCreatingModel(meteoEventDto);
        MeteoEvent meteoEventChecked = this.meteoEventService.getById(id);
        if (meteoEventChecked == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        MeteoEvent updatedMeteoEvent= this.meteoEventService.update(meteoEvent,id);
        return new ResponseEntity<>(toDto(updatedMeteoEvent), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/meteoevent", method = RequestMethod.DELETE)
    public ResponseEntity<List<MeteoEventDto>> deleteMeteoEvent(){
        List<MeteoEvent> meteoEventsList = this.meteoEventService.getAll();
        if(meteoEventsList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

        for(MeteoEvent meteoEvent : meteoEventsList){
            this.eventService.delete(meteoEvent.getId());
        }

        return new ResponseEntity<>(Lists.transform(meteoEventsList, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "meteoevent/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MeteoEventDto> deleteMeteoEventById(@PathVariable("id") Long id){
        MeteoEvent meteoEvent = this.meteoEventService.getById(id);
        if(meteoEvent == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.delete(meteoEvent.getId());
        return new ResponseEntity<>(toDto(meteoEvent), HttpStatus.OK);
    }

    private MeteoEventDto toDto(MeteoEvent meteoEvent) {
        return new MeteoEventDto.Builder()
                .id(meteoEvent.getId())
                .name(meteoEvent.getName())
                .latitude(meteoEvent.getLatitude())
                .longitude(meteoEvent.getLongitude())
                .startingDate(meteoEvent.getStartingTime())
                .endingDate(meteoEvent.getEndingTime())
                .severity(meteoEvent.getSeverity())
                .description(meteoEvent.getDescription())
                .hints(meteoEvent.getHints())
                .radius(meteoEvent.getRadius())
                .precipitationLevel(meteoEvent.getPrecipitationLevel())
                .temperature(meteoEvent.getTemperature())
                .humidity(meteoEvent.getHumidity());
    }

    private MeteoEvent toCreatingModel(CreatingMeteoEventDto dto) {
        return new MeteoEventBuilder()
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
                .getMeteoEvent();
    }


}
