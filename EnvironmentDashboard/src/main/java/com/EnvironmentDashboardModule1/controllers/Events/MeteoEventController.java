package com.EnvironmentDashboardModule1.controllers.Events;

import com.EnvironmentDashboardModule1.DTO.CreatingMeteoEventDto;
import com.EnvironmentDashboardModule1.DTO.MeteoEventDto;
import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.MeteoEventBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.MeteoEvents.MeteoEvent;
import com.EnvironmentDashboardModule1.services.Event.EventMappingService;
import com.EnvironmentDashboardModule1.services.Event.EventService;
import com.EnvironmentDashboardModule1.services.Event.MeteoEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;


import java.util.List;

/**
 * Created by Ariana on 5/13/2017.
 */

/**
 * Controller for meteo event, similar usage in rain, snow, cold weather etc.
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

    /**
     * Response Entity is an extension of HttpEntity that adds a HttpStatus status code.
     * Used in RestTemplate as well @Controller methods. This method adds a meteo event and saves it in a list.
     * The status code which will print will be CREATED if operation was successful and BAD_REQUEST if not.
     * @param event
     * @return void
     */
    @RequestMapping(value = "/meteoevent", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
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
    /**
     * This method returns the list of meteo events.
     * The status code which will print will be OK if operation was successful and NO_CONTENT if not.
     * @return events
     */
    @RequestMapping(value = "/meteoevent", method = RequestMethod.GET)
    public ResponseEntity<List<MeteoEventDto>> getMeteoEvent() {
        List<MeteoEvent> events = this.meteoEventService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }
    /**
     * This method returns a meteo event from the list given its id as a parameter.
     * The status code which will print will be OK if operation was successful and NO_CONTENT if not.
     * @param id
     * @return event
     */
    @RequestMapping(value = "/meteoevent/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<MeteoEventDto> getMeteoEventById(@PathVariable("id") Long id) {
        MeteoEvent meteoEvent = this.meteoEventService.getById(id);
        if (meteoEvent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(meteoEvent), HttpStatus.OK);
    }

    /**
     * This method updates a meteo event given its id and the dto and returns it with the modified values.
     * The status code which will print will be CREATED if operation was successful and NO_CONTENT if not.
     * @param id
     * @param meteoEventDto
     * @return
     */
    @RequestMapping(value = "/meteoevent/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<MeteoEventDto> updateMeteoEvent(@PathVariable("id") Long id,@RequestBody CreatingMeteoEventDto meteoEventDto){
        MeteoEvent meteoEvent = toCreatingModel(meteoEventDto);
        MeteoEvent meteoEventChecked = this.meteoEventService.getById(id);
        if (meteoEventChecked == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        MeteoEvent updatedMeteoEvent= this.meteoEventService.update(meteoEvent,id);
        return new ResponseEntity<>(toDto(updatedMeteoEvent), HttpStatus.CREATED);
    }
    /**
     * This method deletes all meteo events from the list.
     * The status code which will print will be OK if operation was successful and NOT_FOUND if not.
     * @return void
     */
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
    /**
     * This method deletes a meteo event from the list given its id as a parameter.
     * The status code which will print will be OK if operation was successful and NOT_FOUND if not.
     * @param id
     * @return void
     */
    @RequestMapping(value = "meteoevent/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MeteoEventDto> deleteMeteoEventById(@PathVariable("id") Long id){
        MeteoEvent meteoEvent = this.meteoEventService.getById(id);
        if(meteoEvent == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.delete(meteoEvent.getId());
        return new ResponseEntity<>(toDto(meteoEvent), HttpStatus.OK);
    }
    /**
     * This method converts a meteo event into a dto.
     * @param meteoEvent
     * @return dto
     */
    private MeteoEventDto toDto(MeteoEvent meteoEvent) {
        return new MeteoEventDto.Builder()
                .userId(meteoEvent.getUserId())
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

    /**
     * This method converts a dto into a meteo event.
     * @param dto
     * @return meteoEvent
     */
    private MeteoEvent toCreatingModel(CreatingMeteoEventDto dto) {
        return new MeteoEventBuilder()
                .setUserId(dto.getUserId())
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
