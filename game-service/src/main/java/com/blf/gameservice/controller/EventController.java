package com.blf.gameservice.controller;

import com.blf.gameservice.Search.SearchInput;
import com.blf.gameservice.entity.Event;
import com.blf.gameservice.service.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class EventController {


    EventService eventService;

    @GetMapping("")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }


    @PostMapping("/search/")
    public List<Event> getAllEventsBySearch(@RequestBody SearchInput input){
        return eventService.getEventsBySearch(input);
    }

    @PostMapping("/search/{seasonId}")
    public List<Event> getAllEventsBySeasonAndSearch(@PathVariable Long seasonId, @RequestBody(required = false) SearchInput input){
        return eventService.getEventsBySeasonAndSearch(seasonId, input);
    }

    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId);
    }

    @PostMapping("/add")
    public Event addNewEvent(@RequestBody Event event) {
        log.info("The following event is added to database: " + event);
        return eventService.addNewEvent(event);
    }

    @PutMapping("/edit/{eventId}")
    public Event updateEvent(@PathVariable Long eventId, @RequestBody Event updatedEvent) {
        return eventService.updateEvent(eventId, updatedEvent);
    }

    @DeleteMapping("/delete/{eventId}")
    public Event deleteEvent(@PathVariable Long eventId) {
        return eventService.deleteEvent(eventId);
    }

}
