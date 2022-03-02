package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be at least 3 characters and no longer than 50 characters")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @Valid
    private EventDetails eventDetails;

    @ManyToOne
    @NotNull
    private EventCategory eventCategory;

    @ManyToMany
    private List<Tag> tags = new ArrayList<>();

    public Event(String name) {
        this.name = name;
    }

    // no-arg constructor
    public Event () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
