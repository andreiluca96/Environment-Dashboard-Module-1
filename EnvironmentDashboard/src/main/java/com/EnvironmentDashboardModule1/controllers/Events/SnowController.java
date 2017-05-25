
package com.EnvironmentDashboardModule1.controllers.Events;

import com.EnvironmentDashboardModule1.DTO.CreatingSnowDto;
import com.EnvironmentDashboardModule1.DTO.SnowDto;
import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.SnowBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.MeteoEvents.Snow;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.SnowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;
import java.util.List;
/**
 *
 * @author Vladut
 */
public class SnowController {
    @RestController
@RequestMapping("v1/events")
public class FloodController {

    @Autowired
    private EventService eventService;

    @Autowired
    private SnowService snowService;

    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(value = "/snow", method = RequestMethod.POST)
    public ResponseEntity<Snow> addSnow(@RequestBody CreatingSnowDto event) {
        Snow snow = toCreatingModel(event);
        Snow savedEvent = this.snowService.save(snow);
        if(snow==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        EventMapping eventMapping = new EventMapping(savedEvent.getId(), "Snow");
        eventMappingService.save(eventMapping);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/snow", method = RequestMethod.GET)
    public ResponseEntity<List<SnowDto>> getSnow() {
        List<Snow> events = this.snowService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/snow/{id}", method = RequestMethod.GET)
    public ResponseEntity<SnowDto> getSnowById(@PathVariable("id") Long id) {
        Snow snow = this.snowService.getById(id);
        if (snow == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(snow), HttpStatus.OK);
    }

    @RequestMapping(value = "/snow/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SnowDto> updateSnow(@PathVariable("id") Long id,@RequestBody CreatingSnowDto snowDto){
        Snow snow = toCreatingModel(snowDto);
        Snow snowCheck = this.snowService.getById(id);
        if (snowCheck == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Snow updatedsnow= this.snowService.update(snow,id);
        return new ResponseEntity<>(toDto(updatedsnow), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/flood", method = RequestMethod.DELETE)
    public ResponseEntity<List<SnowDto>> deleteSnow() {
        List<Snow> snowList = this.snowService.getAll();
            if(snowList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
        snowList.forEach((snow) -> {
            this.eventService.delete(snow.getId());
        });

        return new ResponseEntity<>(Lists.transform(snowList, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "snow/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SnowDto> deleteSnowById(@PathVariable("id") Long id) {
        Snow snow = this.snowService.getById(id);
        if (snow == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.delete(snow.getId());
        return new ResponseEntity<>(toDto(snow), HttpStatus.OK);
    }


    private SnowDto toDto(Snow snow) {
        return new SnowDto.Builder()
                .id(snow.getId())
                .name(snow.getName())
                .latitude(snow.getLatitude())
                .longitude(snow.getLongitude())
                .startingDate(snow.getStartingTime())
                .endingDate(snow.getEndingTime())
                .severity(snow.getSeverity())
                .description(snow.getDescription())
                .hints(snow.getHints())
                .radius(snow.getRadius())
                .precipitationLevel(snow.getPrecipitationLevel());
    }

    private Snow toCreatingModel(CreatingSnowDto dto) {
        return new SnowBuilder()
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLongitude())
                .setDescription(dto.getDescription())
                .setEndingTime(dto.getEndingDate())
                .setStartingTime(dto.getStartingDate())
                .setHints(dto.getHints())
                .setRadius(dto.getRadius())
                .setSeverity(dto.getSeverity())
                .setPrecipitationLevel(dto.getPrecipitationLevel())
                .getSnow();
    }
}
}
