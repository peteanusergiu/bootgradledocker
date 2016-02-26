package org.experiment.lang.generic;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A response with an event as payload.
 */
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@ApiModel(description = "A response with an event as payload.")
public final class EventResponse extends BaseResponse {

    /**
     * The event returned with this response.
     */
    @XmlElement
    @ApiModelProperty(value = "The event returned with this response.")
    private final Event event;

    /**
     * Constructs a new {@code EventResponse}.
     */
    public EventResponse() {
        this.event = null;
    }

    /**
     * Constructs a new {@code ContactResponse}.
     *
     * @param event The event of the response.
     */
    public EventResponse(Event event) {
        this.event = event;
    }

    /**
     * Returns the event of this response.
     *
     * @return The event of this response.
     */
    public Event getEvent() {
        return this.event;
    }
}

