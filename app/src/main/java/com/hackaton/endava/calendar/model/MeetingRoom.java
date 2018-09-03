package com.hackaton.endava.calendar.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class MeetingRoom {
    private String calendarId;
    private String name;
    private String fileName;
}
