package com.EnvironmentDashboardModule1.controllers;

import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
