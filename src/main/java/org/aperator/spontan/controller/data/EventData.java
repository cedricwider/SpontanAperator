package org.aperator.spontan.controller.data;

import org.aperator.spontan.controller.data.mapper.JsonDateFormatter;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 11/04/14
 * Time: 17:44
 */
public class EventData {

    private Long id;
    private Date date;
    private Long ownerId;
    private List<Long> participantIds;
    private String location;
    private String motto;
    private String description;

    public EventData() {
        this.participantIds = new LinkedList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = JsonDateFormatter.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public List<Long> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(List<Long> participantIds) {
        this.participantIds = participantIds;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
