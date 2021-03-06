package com.EnvironmentDashboardModule1.controllers.Events;

import com.EnvironmentDashboardModule1.DTO.CreatingEarthquakeDto;
import com.EnvironmentDashboardModule1.DTO.EarthquakeDto;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.EarthquakeBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.Events.Earthquake;
import com.EnvironmentDashboardModule1.services.Event.EarthquakeService;
import com.EnvironmentDashboardModule1.services.Event.EventMappingService;
import com.EnvironmentDashboardModule1.services.Event.EventService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sabina on 5/8/2017.
 */

@RestController
@RequestMapping("v1/events")
public class EarthquakeController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EarthquakeService earthquakeService;

    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(value = "/earthquake", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Earthquake> addEarthquake(@RequestBody CreatingEarthquakeDto event) {
        Earthquake earthquake = toCreatingModel(event);
        Earthquake savedEvent = this.earthquakeService.save(earthquake);
        if(earthquake==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventMapping eventMapping = new EventMapping(savedEvent.getId(), "Earthquake");
        eventMappingService.save(eventMapping);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/earthquake", method = RequestMethod.GET)
    public ResponseEntity<List<EarthquakeDto>> getEarthquakes() {
        List<Earthquake> events = this.earthquakeService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/earthquake/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EarthquakeDto> getEarthquakeById(@PathVariable("id") Long id) {
        Earthquake earthquake = this.earthquakeService.getById(id);
        if (earthquake == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(earthquake), HttpStatus.OK);
    }

    @RequestMapping(value = "/earthquake/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EarthquakeDto> updateEarthquake(@PathVariable("id") Long id,@RequestBody CreatingEarthquakeDto earthquakeDto){
        Earthquake earthquake = toCreatingModel(earthquakeDto);
        Earthquake earthquaketCheck = this.earthquakeService.getById(id);
        if (earthquaketCheck == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Earthquake updatedEarthquake= this.earthquakeService.update(earthquake,id);
        return new ResponseEntity<>(toDto(updatedEarthquake), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/earthquake", method = RequestMethod.DELETE)
    public ResponseEntity<List<EarthquakeDto>> deleteEarthquakes(){
        List<Earthquake> earthquakeList = this.earthquakeService.getAll();
        if(earthquakeList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
        for(Earthquake earthquake : earthquakeList){
            this.eventService.delete(earthquake.getId());
        }

        return new ResponseEntity<>(Lists.transform(earthquakeList, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "earthquake/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<EarthquakeDto> deleteEarthquakeById(@PathVariable("id") Long id){
        Earthquake earthquake = this.earthquakeService.getById(id);
        if(earthquake == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.delete(earthquake.getId());
        return new ResponseEntity<>(toDto(earthquake), HttpStatus.OK);
    }

    private EarthquakeDto toDto(Earthquake earthquake) {
        return new EarthquakeDto.Builder()
                .userId(earthquake.getUserId())
                .id(earthquake.getId())
                .name(earthquake.getName())
                .latitude(earthquake.getLatitude())
                .longitude(earthquake.getLongitude())
                .startingDate(earthquake.getStartingTime())
                .endingDate(earthquake.getEndingTime())
                .severity(earthquake.getSeverity())
                .description(earthquake.getDescription())
                .hints(earthquake.getHints())
                .radius(earthquake.getRadius())
                .mercaliDegree(earthquake.getMercalliDegree())
                .richterDegree(earthquake.getRichterDegree())
                .depth(earthquake.getDepth());
    }

    private Earthquake toCreatingModel(CreatingEarthquakeDto dto) {
        return new EarthquakeBuilder()
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
                .setRichterDegree(dto.getRichterDegree())
                .setMercalliDegree(dto.getMercaliDegree())
                .setDepth(dto.getDepth())
                .getEarthquake();
    }

}
