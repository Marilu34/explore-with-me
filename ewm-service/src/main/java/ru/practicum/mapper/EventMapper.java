package ru.practicum.mapper;

import lombok.experimental.UtilityClass;
import ru.practicum.model.Category;
import ru.practicum.model.Event;
import ru.practicum.dto.EventDto;
import ru.practicum.dto.EventDtoRequest;
import ru.practicum.model.Location;
import ru.practicum.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class EventMapper {

    public static Event toEvent(EventDtoRequest eventDto, User user) {
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setAnnotation(eventDto.getAnnotation());
        event.setCategory(new Category(eventDto.getCategory(), null));
        event.setDescription(eventDto.getDescription());
        event.setEventDate(eventDto.getEventDate());
        event.setLon(eventDto.getLocation().getLon());
        event.setLat(eventDto.getLocation().getLat());
        event.setPaid(eventDto.getPaid());
        event.setParticipantLimit(eventDto.getParticipantLimit());
        event.setTitle(eventDto.getTitle());
        event.setInitiator(user);
        event.setRequestModeration(eventDto.getRequestModeration());
        event.setCreatedOn(LocalDateTime.now());
        return event;
    }

    public static EventDto toEventDto(Event event) {
        return new EventDto(event.getId(),
                event.getAnnotation(),
                event.getCategory(),
                event.getConfirmedRequests(),
                event.getCreatedOn(),
                event.getDescription(),
                event.getEventDate(),
                event.getInitiator(),
                new Location(event.getLat(), event.getLon()),
                event.isPaid(),
                event.getParticipantLimit(),
                event.getPublishedOn(),
                event.isRequestModeration(),
                event.getState(),
                event.getTitle(),
                event.getViews());
    }

    public static List<EventDto> toEventDtoList(List<Event> events) {
        List<EventDto> eventDto = new ArrayList<>();
        for (Event event : events) {
            eventDto.add(toEventDto(event));
        }
        return eventDto;
    }
}