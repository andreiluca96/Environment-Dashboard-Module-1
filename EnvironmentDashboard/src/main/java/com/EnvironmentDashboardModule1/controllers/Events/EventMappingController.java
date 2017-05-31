package com.EnvironmentDashboardModule1.controllers.Events;

import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.services.Event.EventMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Luca Andrei on 5/18/2017.
 */

@RestController
@RequestMapping("v1/eventMappings")
public class EventMappingController {
    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EventMapping>> get() {
        List<EventMapping> events = this.eventMappingService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EventMapping> getById(@PathVariable("id") Long id) {
        EventMapping eventMapping = this.eventMappingService.getById(id);
        if (eventMapping == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(eventMapping, HttpStatus.OK);
    }

}
