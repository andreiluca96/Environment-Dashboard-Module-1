package com.EnvironmentDashboardModule1.controllers;

import com.EnvironmentDashboardModule1.DTO.*;
import com.EnvironmentDashboardModule1.models.Builders.EarthquakeBuilder;
import com.EnvironmentDashboardModule1.models.Builders.TornadoBuilder;
import com.EnvironmentDashboardModule1.models.Events.Earthquake;
import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilder;
import com.EnvironmentDashboardModule1.models.Events.Tornado;
import com.EnvironmentDashboardModule1.services.EarthquakeService;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.TornadoService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
@RestController
@RequestMapping("v1/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private TornadoService tornadoService;

    @Autowired
    private EarthquakeService earthquakeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EventDto>> get() {
        List<Event> events = this.eventService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EventDto> getById(@PathVariable("id") Long id) {
        Event event = this.eventService.getById(id);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(event), HttpStatus.OK);
    }

    @RequestMapping(value = "/tornado", method = RequestMethod.GET)
    public ResponseEntity<List<TornadoDto>> getTornado() {
        List<Tornado> events = this.tornadoService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/tornado/{id}", method = RequestMethod.GET)
    public ResponseEntity<TornadoDto> getTornadoById(@PathVariable("id") Long id) {
        Tornado tornado = this.tornadoService.getById(id);
        if (tornado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(tornado), HttpStatus.OK);
    }

    @RequestMapping(value = "/earthquake", method = RequestMethod.GET)
    public ResponseEntity<List<EarthquakeDto>> getEarthquake() {
        List<Earthquake> events = this.earthquakeService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }


    @RequestMapping(value = "/earthquake/{id}", method = RequestMethod.GET)
    public ResponseEntity<EarthquakeDto> getEarthquakeById(@PathVariable("id") Long id) {
        Earthquake earthquake = this.earthquakeService.getById(id);
        if (earthquake == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(earthquake), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Event> addEvent(@RequestBody CreatingEventDto eventDto) {
        Event event = toCreatingModel(eventDto);
        Event savedEvent = this.eventService.save(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tornado", method = RequestMethod.POST)
    public ResponseEntity<Tornado> addTornado(@RequestBody CreatingTornadoDto event) {
        Tornado tornado = toCreatingModel(event);
        Tornado savedEvent = this.tornadoService.save(tornado);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/earthquake", method = RequestMethod.POST)
    public ResponseEntity<Earthquake> addTornado(@RequestBody CreatingEarthquakeDto event) {
        Earthquake earthquake = toCreatingModel(event);
        Earthquake savedEvent = this.earthquakeService.save(earthquake);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<List<EventDto>> delete(){
        List<Event> eventList = this.eventService.getAll();

        for(Event event : eventList){
            this.eventService.delete(event.getId());
        }

        return new ResponseEntity<>(Lists.transform(eventList, event -> toDto(event)), HttpStatus.OK);
    }


    @RequestMapping(value = "/tornado", method = RequestMethod.DELETE)
    public ResponseEntity<List<TornadoDto>> deleteTornados(){
        List<Tornado> tornadoList = this.tornadoService.getAll();

        for(Tornado tornado : tornadoList){
            this.eventService.delete(tornado.getId());
        }

        return new ResponseEntity<>(Lists.transform(tornadoList, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/earthquake", method = RequestMethod.DELETE)
    public ResponseEntity<List<EarthquakeDto>> deleteEarthquakes(){
        List<Earthquake> earthquakeList = this.earthquakeService.getAll();

        for(Earthquake earthquake : earthquakeList){
            this.eventService.delete(earthquake.getId());
        }

        return new ResponseEntity<>(Lists.transform(earthquakeList, event -> toDto(event)), HttpStatus.OK);
    }


    private EventDto toDto(Event event) {
        return new EventDto.Builder()
                .name(event.getName())
                .latitude(event.getLatitude())
                .longitude(event.getLongitude())
                .startingDate(event.getStartingTime())
                .endingDate(event.getEndingTime())
                .severity(event.getSeverity())
                .description(event.getDescription())
                .hints(event.getHints())
                .radius(event.getRadius());
    }

    private Event toCreatingModel(CreatingEventDto dto) {
        return new EventBuilder()
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLongitude())
                .setDescription(dto.getDescription())
                .setEndingTime(dto.getEndingDate())
                .setStartingTime(dto.getStartingDate())
                .setHints(dto.getHints())
                .setRadius(dto.getRadius())
                .setSeverity(dto.getSeverity())
                .getEvent();
    }

    private TornadoDto toDto(Tornado tornado) {
        return new TornadoDto.Builder()
                .name(tornado.getName())
                .latitude(tornado.getLatitude())
                .longitude(tornado.getLongitude())
                .startingDate(tornado.getStartingTime())
                .endingDate(tornado.getEndingTime())
                .severity(tornado.getSeverity())
                .description(tornado.getDescription())
                .hints(tornado.getHints())
                .radius(tornado.getRadius())
                .windspeed(tornado.getWindSpeed());
    }

    private Tornado toCreatingModel(CreatingTornadoDto dto) {
        return new TornadoBuilder()
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLongitude())
                .setDescription(dto.getDescription())
                .setEndingTime(dto.getEndingDate())
                .setStartingTime(dto.getStartingDate())
                .setHints(dto.getHints())
                .setRadius(dto.getRadius())
                .setSeverity(dto.getSeverity())
                .setWindspeed(dto.getWindspeed())
                .getTornado();
    }

    private EarthquakeDto toDto(Earthquake earthquake) {
        return new EarthquakeDto.Builder()
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
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLongitude())
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


//    //earthquake
//    @Autowired
//    private EarthquakeService earthquakeService;
//
//    @RequestMapping(value = "/earthquake", method = RequestMethod.GET)
//    public ResponseEntity<List<EarthquakeDto>> getEarthquake() {
//        List<Earthquake> events = this.earthquakeService.getAll();
//        if (events.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/earthquake", method = RequestMethod.POST)
//    public ResponseEntity<Tornado> addEarthquake(@RequestBody Earthquake event) {
//        Earthquake savedEvent = this.earthquakeService.save(event);
//        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
//    }
//

//
//
//    //Fire
//    @Autowired
//    private FireService fireService;
//
//    @RequestMapping(value = "/fire", method = RequestMethod.GET)
//    public ResponseEntity<List<FireDto>> getFire() {
//        List<Fire> events = this.fireService.getAll();
//        if (events.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/fire", method = RequestMethod.POST)
//    public ResponseEntity<Fire> addFire(@RequestBody Fire event) {
//        Fire savedEvent = this.fireService.save(event);
//        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
//    }
//
//    private FireDto toDto(Fire fire) {
//        return new FireDto.Builder()
//                .name(fire.getName())
//                .latitude(fire.getLatitude())
//                .longitude(fire.getLongitude())
//                .startingDate(fire.getStartingTime())
//                .endingDate(fire.getEndingTime())
//                .severity(fire.getSeverity())
//                .description(fire.getDescription())
//                .hints(fire.getHints())
//                .radius(fire.getRadius())
//                .speed(fire.getSpeed());
//    }
//
//    private Fire toCreatingModel(CreatingFireDto dto) {
//        return new FireBuilder()
//                .setName(dto.getName())
//                .setLongitude(dto.getLongitude())
//                .setLatitude(dto.getLongitude())
//                .setDescription(dto.getDescription())
//                .setEndingTime(dto.getEndingDate())
//                .setStartingTime(dto.getStartingDate())
//                .setHints(dto.getHints())
//                .setRadius(dto.getRadius())
//                .setSeverity(dto.getSeverity())
//                .setSpeed(dto.getSpeed())
//                .getFire();
//    }
//
//    //TerroristAttack
//    @Autowired
//    private TerroristAttackService terroristAttackService;
//
//    @RequestMapping(value = "/terroristAttack", method = RequestMethod.GET)
//    public ResponseEntity<List<TerroristAttackDto>> getTerroristAttack() {
//        List<TerroristAttack> events = this.terroristAttackService.getAll();
//        if (events.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/terroristAttack", method = RequestMethod.POST)
//    public ResponseEntity<TerroristAttack> addTerroristAttack(@RequestBody TerroristAttack event) {
//        TerroristAttack savedEvent = this.terroristAttackService.save(event);
//        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
//    }
//
//    private TerroristAttackDto toDto(TerroristAttack terroristAttack) {
//        return new TerroristAttackDto.Builder()
//                .name(terroristAttack.getName())
//                .latitude(terroristAttack.getLatitude())
//                .longitude(terroristAttack.getLongitude())
//                .startingDate(terroristAttack.getStartingTime())
//                .endingDate(terroristAttack.getEndingTime())
//                .severity(terroristAttack.getSeverity())
//                .description(terroristAttack.getDescription())
//                .hints(terroristAttack.getHints())
//                .radius(terroristAttack.getRadius())
//                .numberOfTerrorists(terroristAttack.getNumberOfTerrorists());
//    }
//
//    private TerroristAttack toCreatingModel(CreatingTerroristAttackDto dto) {
//        return new TerroristAttackBuilder()
//                .setName(dto.getName())
//                .setLongitude(dto.getLongitude())
//                .setLatitude(dto.getLongitude())
//                .setDescription(dto.getDescription())
//                .setEndingTime(dto.getEndingDate())
//                .setStartingTime(dto.getStartingDate())
//                .setHints(dto.getHints())
//                .setRadius(dto.getRadius())
//                .setSeverity(dto.getSeverity())
//                .setNumberOfTerrorists(dto.getNumberOfTerrorists())
//                .getTerroristAttack();
//    }
//
//    //tsunami
//    @Autowired
//    private TsunamiService tsunamiService;
//
//    @RequestMapping(value = "/tsunami", method = RequestMethod.GET)
//    public ResponseEntity<List<TsunamiDto>> getTsunami() {
//        List<Tsunami> events = this.tsunamiService.getAll();
//        if (events.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/tsunami", method = RequestMethod.POST)
//    public ResponseEntity<Tsunami> addTsunami(@RequestBody Tsunami event) {
//        Tsunami savedEvent = this.tsunamiService.save(event);
//        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
//    }
//
//    private TsunamiDto toDto(Tsunami tsunami) {
//        return new TsunamiDto.Builder()
//                .name(tsunami.getName())
//                .latitude(tsunami.getLatitude())
//                .longitude(tsunami.getLongitude())
//                .startingDate(tsunami.getStartingTime())
//                .endingDate(tsunami.getEndingTime())
//                .severity(tsunami.getSeverity())
//                .description(tsunami.getDescription())
//                .hints(tsunami.getHints())
//                .radius(tsunami.getRadius())
//                .maxWaveHeight(tsunami.getMaxWaveHeight());
//    }
//
//    private Tsunami toCreatingModel(CreatingTsunamiDto dto) {
//        return new TsunamiBuilder()
//                .setName(dto.getName())
//                .setLongitude(dto.getLongitude())
//                .setLatitude(dto.getLongitude())
//                .setDescription(dto.getDescription())
//                .setEndingTime(dto.getEndingDate())
//                .setStartingTime(dto.getStartingDate())
//                .setHints(dto.getHints())
//                .setRadius(dto.getRadius())
//                .setSeverity(dto.getSeverity())
//                .setMaxWaveHeight(dto.getMaxWaveHeight())
//                .getTsunami();
//    }
//
//    //flood
//    @Autowired
//    private FloodService floodService;
//
//    @RequestMapping(value = "/flood", method = RequestMethod.GET)
//    public ResponseEntity<List<FloodDto>> getFlood() {
//        List<Flood> events = this.floodService.getAll();
//        if (events.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/flood", method = RequestMethod.POST)
//    public ResponseEntity<Flood> addFlood(@RequestBody Flood event) {
//        Flood savedEvent = this.floodService.save(event);
//        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
//    }
//
//    private FloodDto toDto(Flood flood) {
//        return new FloodDto.Builder()
//                .name(flood.getName())
//                .latitude(flood.getLatitude())
//                .longitude(flood.getLongitude())
//                .startingDate(flood.getStartingTime())
//                .endingDate(flood.getEndingTime())
//                .severity(flood.getSeverity())
//                .description(flood.getDescription())
//                .hints(flood.getHints())
//                .radius(flood.getRadius())
//                .precipitationLevel(flood.getPrecipitationLevel());
//    }
//
//    private Flood toCreatingModel(CreatingFloodDto dto) {
//        return new FloodBuilder()
//                .setName(dto.getName())
//                .setLongitude(dto.getLongitude())
//                .setLatitude(dto.getLongitude())
//                .setDescription(dto.getDescription())
//                .setEndingTime(dto.getEndingDate())
//                .setStartingTime(dto.getStartingDate())
//                .setHints(dto.getHints())
//                .setRadius(dto.getRadius())
//                .setSeverity(dto.getSeverity())
//                .setPrecipitationLevel(dto.getPrecipitationLevel())
//                .getFlood();
//    }
}