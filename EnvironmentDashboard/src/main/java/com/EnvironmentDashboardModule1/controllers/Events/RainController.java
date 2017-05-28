package com.EnvironmentDashboardModule1.controllers.Events;

import com.EnvironmentDashboardModule1.DTO.CreatingRainDto;
import com.EnvironmentDashboardModule1.DTO.RainDto;
import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.RainBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.MeteoEvents.Rain;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.MeteoEventService;
import com.EnvironmentDashboardModule1.services.RainService;
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
public class RainController {

    @Autowired
    private MeteoEventService meteoEventService;

    @Autowired
    private RainService rainService;

    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(value = "/rain", method = RequestMethod.POST)
    public ResponseEntity<Rain> addRain(@RequestBody CreatingRainDto meteoEvent) {
        Rain rain = toCreatingModel(meteoEvent);
        Rain savedMeteoEvent = this.rainService.save(rain);
        if(rain==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventMapping eventMapping = new EventMapping(savedMeteoEvent.getId(), "Rain");
        eventMappingService.save(eventMapping);

        return new ResponseEntity<>(savedMeteoEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rain", method = RequestMethod.GET)
    public ResponseEntity<List<RainDto>> getRain() {
        List<Rain> meteoEvents = this.rainService.getAll();
        if (meteoEvents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(meteoEvents, meteoEvent -> toDto(meteoEvent)), HttpStatus.OK);
    }

    @RequestMapping(value = "/rain/{id}", method = RequestMethod.GET)
    public ResponseEntity<RainDto> getRainById(@PathVariable("id") Long id) {
        Rain rain = this.rainService.getById(id);
        if (rain == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(rain), HttpStatus.OK);
    }

    @RequestMapping(value = "/rain/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RainDto> updateRain(@PathVariable("id") Long id,@RequestBody CreatingRainDto rainDto){
        Rain rain = toCreatingModel(rainDto);
        Rain rainChecked = this.rainService.getById(id);
        if (rainChecked == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Rain updatedRain= this.rainService.update(rain,id);
        return new ResponseEntity<>(toDto(updatedRain), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rain", method = RequestMethod.DELETE)
    public ResponseEntity<List<RainDto>> deleteRain(){
        List<Rain> rainList = this.rainService.getAll();
            if(rainList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
        for(Rain rain : rainList){
            this.rainService.delete(rain.getId());
        }

        return new ResponseEntity<>(Lists.transform(rainList, meteoEvent -> toDto(meteoEvent)), HttpStatus.OK);
    }

    @RequestMapping(value = "rain/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<RainDto> deleteRainById(@PathVariable("id") Long id){
        Rain rain = this.rainService.getById(id);
        if(rain == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.meteoEventService.delete(rain.getId());
        return new ResponseEntity<>(toDto(rain), HttpStatus.OK);
    }

    private RainDto toDto(Rain rain) {
        return new RainDto.Builder()
                .id(rain.getId())
                .name(rain.getName())
                .latitude(rain.getLatitude())
                .longitude(rain.getLongitude())
                .startingDate(rain.getStartingTime())
                .endingDate(rain.getEndingTime())
                .severity(rain.getSeverity())
                .description(rain.getDescription())
                .hints(rain.getHints())
                .radius(rain.getRadius())
                .precipitationLevel(rain.getPrecipitationLevel())
                .temperature(rain.getTemperature())
                .humidity(rain.getHumidity());
    }

    private Rain toCreatingModel(CreatingRainDto dto) {
        return new RainBuilder()
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
                .getRain();
    }


}