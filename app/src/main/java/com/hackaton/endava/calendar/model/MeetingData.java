package com.hackaton.endava.calendar.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MeetingData {
    private String organizer;
    private String start;
    private String end;
}
