package com.EnvironmentDashboardModule1.controllers.Events;

/**
 * Created by Sabina on 5/8/2017.
 */

import com.EnvironmentDashboardModule1.DTO.CreatingFireDto;
import com.EnvironmentDashboardModule1.DTO.FireDto;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.FireBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.Events.Fire;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.FireService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/events")
public class FireController {

    @Autowired
    private EventService eventService;

    @Autowired
    private FireService fireService;

    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(value = "/fire", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Fire> addFire(@RequestBody CreatingFireDto event) {
        Fire fire = toCreatingModel(event);
        Fire savedEvent = this.fireService.save(fire);
        if(fire==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventMapping eventMapping = new EventMapping(savedEvent.getId(), "Fire");
        eventMappingService.save(eventMapping);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/fire", method = RequestMethod.GET)
    public ResponseEntity<List<FireDto>> getFire() {
        List<Fire> events = this.fireService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/fire/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<FireDto> getFireById(@PathVariable("id") Long id) {
        Fire fire = this.fireService.getById(id);
        if (fire == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(fire), HttpStatus.OK);
    }

    @RequestMapping(value = "/fire/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<FireDto> updateFire(@PathVariable("id") Long id, @RequestBody CreatingFireDto fireDto) {
        Fire fire = toCreatingModel(fireDto);
        Fire fireCheck = this.fireService.getById(id);
        if (fireCheck == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Fire updatedFire = this.fireService.update(fire, id);
        return new ResponseEntity<>(toDto(updatedFire), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/fire", method = RequestMethod.DELETE)
    public ResponseEntity<List<FireDto>> deleteFire() {
        List<Fire> fireList = this.fireService.getAll();
        if(fireList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (Fire fire : fireList) {
            this.eventService.delete(fire.getId());
        }

        return new ResponseEntity<>(Lists.transform(fireList, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "fire/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<FireDto> deleteFireById(@PathVariable("id") Long id) {
        Fire fire = this.fireService.getById(id);
        if (fire == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.delete(fire.getId());
        return new ResponseEntity<>(toDto(fire), HttpStatus.OK);
    }


    private FireDto toDto(Fire fire) {
        return new FireDto.Builder()
                .userId(fire.getUserId())
                .id(fire.getId())
                .name(fire.getName())
                .latitude(fire.getLatitude())
                .longitude(fire.getLongitude())
                .startingDate(fire.getStartingTime())
                .endingDate(fire.getEndingTime())
                .severity(fire.getSeverity())
                .description(fire.getDescription())
                .hints(fire.getHints())
                .radius(fire.getRadius())
                .speed(fire.getSpeed());
    }

    private Fire toCreatingModel(CreatingFireDto dto) {
        return new FireBuilder()
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
                .setSpeed(dto.getSpeed())
                .getFire();
    }
}
