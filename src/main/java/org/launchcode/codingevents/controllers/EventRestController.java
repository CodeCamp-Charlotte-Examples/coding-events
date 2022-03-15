package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Chris Bay
 */
@RequestMapping("api/events")
@RestController
public class EventRestController {

    @Autowired
    private EventRepository eventRepository;

    // handles GET /api/events
    @GetMapping
    public List<Event> events() {
        return eventRepository.findAll();
    }

    // handles GET /api/events/3
    @GetMapping("{id}")
    public Event eventById(@PathVariable int id) {
        return eventRepository.findById(id).orElseThrow();
    }

    // handles PUT /api/events/4 (updated event info in JSON body)
    @PutMapping("{id}")
    public Event update(@RequestBody Event updatedEvent, @PathVariable Integer id) {

        Event event = eventRepository.findById(id).orElseThrow();
        event.setName(updatedEvent.getName());
        event.setContactEmail(updatedEvent.getContactEmail());
        event.setDescription(updatedEvent.getDescription());
        event.setType(updatedEvent.getType());

        return eventRepository.save(event);
    }

    // handles POST /api/events (with event info in JSON body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@RequestBody Event newEvent) {
        return eventRepository.save(newEvent);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        eventRepository.deleteById(id);
    }

}
