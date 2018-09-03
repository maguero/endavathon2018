package com.hackaton.endava.calendar;

import com.hackaton.endava.calendar.model.MeetingRoom;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class MeetingRoomManager {
    private static Map<String, MeetingRoom> meetingRooms = new HashMap<>();

    public MeetingRoom getMeetingRommByName(String name){
        return new MeetingRoom();
    }

    public void buildMeetingRooms(){

    }
}
