package com.EnvironmentDashboardModule1.controllers.Events;

import com.EnvironmentDashboardModule1.DTO.CreatingEventDto;
import com.EnvironmentDashboardModule1.DTO.EarthquakeDto;
import com.EnvironmentDashboardModule1.DTO.EventDto;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.EventBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.Events.Earthquake;
import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.models.Severity;
import com.EnvironmentDashboardModule1.services.Event.EarthquakeService;
import com.EnvironmentDashboardModule1.services.Event.EarthquakeServiceImpl;
import com.EnvironmentDashboardModule1.services.Event.EventMappingService;
import com.EnvironmentDashboardModule1.services.Event.EventService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Luca Andrei on 5/4/2017.
 */

/**
 * Controller for event, similar usage in earthquake, fire, flood etc.
 */
@RestController
@RequestMapping("v1/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventMappingService eventMappingService;

    /**
     * Response Entity is an extension of HttpEntity that adds a HttpStatus status code.
     * Used in RestTemplate as well @Controller methods. This method adds an event and saves it in a list.
     * The status code which will print will be CREATED if operation was successful and BAD_REQUEST if not.
     * @param eventDto
     * @return void
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Event> addEvent(@RequestBody CreatingEventDto eventDto) {
        Event event = toCreatingModel(eventDto);
        Event savedEvent = this.eventService.save(event);
        if(event==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventMapping eventMapping = new EventMapping(savedEvent.getId(), "Event");
        eventMappingService.save(eventMapping);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    /**
     * This method returns the list of events.
     * The status code which will print will be OK if operation was successful and NO_CONTENT if not.
     * @return events
     */
    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<EventDto>> get() {
        List<Event> events = this.eventService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    /**
     * This method returns an event from the list given its id as a parameter.
     * The status code which will print will be OK if operation was successful and NO_CONTENT if not.
     * @param id
     * @return event
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EventDto> getById(@PathVariable("id") Long id) {
        Event event = this.eventService.getById(id);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(event), HttpStatus.OK);
    }

    /**
     * This method updates an event given its id and the dto and returns it with the modified values.
     * The status code which will print will be CREATED if operation was successful and NO_CONTENT if not.
     * @param id
     * @param eventDto
     * @return events
     */
    @RequestMapping(value = "/event/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EventDto> updateEvent(@PathVariable("id") Long id, @RequestBody CreatingEventDto eventDto) {
        Event event = toCreatingModel(eventDto);
        Event eventCheck = this.eventService.getById(id);
        if (eventCheck == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Event updatedEvent = this.eventService.update(event, id);
        return new ResponseEntity<>(toDto(updatedEvent), HttpStatus.CREATED);
    }

    /**
     * This method deletes all events from the list.
     * The status code which will print will be OK if operation was successful and NOT_FOUND if not.
     * @return void
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<List<EventDto>> delete() {
        List<Event> eventList = this.eventService.getAll();
        if(eventList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (Event event : eventList) {
            this.eventService.delete(event.getId());
        }

        return new ResponseEntity<>(Lists.transform(eventList, event -> toDto(event)), HttpStatus.OK);
    }

    /**
     * This method deletes an event from the list given its id as a parameter.
     * The status code which will print will be OK if operation was successful and NOT_FOUND if not.
     * @param id
     * @return void
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EventDto> deleteById(@PathVariable("id") Long id) {
        Event event = this.eventService.getById(id);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.delete(event.getId());
        return new ResponseEntity<>(toDto(event), HttpStatus.OK);
    }

    /**
     * This method converts an event into a dto.
     * @param event
     * @return dto
     */
    public EventDto toDto(Event event) {
        return new EventDto.Builder()
                .userId(event.getUserId())
                .id(event.getId())
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

    /**
     * This method converts a dto into an event.
     * @param dto
     * @return event
     */
    private Event toCreatingModel(CreatingEventDto dto) {
        return new EventBuilder()
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
                .getEvent();
    }

    public void eventGeneration(){
        Calendar calendar = Calendar.getInstance();

        Date startingDate = new Date();
        Date endingDate = new Date();

        calendar.setTime(endingDate);
        calendar.add(Calendar.DATE, 5);

        endingDate = calendar.getTime();


        Earthquake earthquake = new Earthquake();
        earthquake.setId((long)1);
        earthquake.setUserId("User current");
        earthquake.setName("Cutremur Jimmy");
        earthquake.setStartingTime(startingDate);
        earthquake.setEndingTime(endingDate);
        earthquake.setSeverity(Severity.ORANGE);
        earthquake.setDescription("Cutremur foarte periculos.");
        earthquake.setHints("Nu va panicati. Ramaneti sub grinda.");
        earthquake.setLatitude(20.3);
        earthquake.setLongitude(20.4);
        earthquake.setRadius(40.3);
        earthquake.setMercalliDegree(5.3);
        earthquake.setRichterDegree(7.4);
        earthquake.setDepth(600);

        EarthquakeService earthquakeService = new EarthquakeServiceImpl();
        earthquakeService.save()
    }
}
