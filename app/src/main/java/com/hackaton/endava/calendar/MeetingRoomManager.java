package com.hackaton.endava.calendar;

import com.hackaton.endava.calendar.model.MeetingRoom;

import java.util.HashMap;
import java.util.Map;

public class MeetingRoomManager {

    public static class Manager {
        public static Map<String, MeetingRoom> meetingRooms = new HashMap<>();

        public static void buildMeetingRooms() {
            meetingRooms.put(MeetingRoomsConstants.PortlandRoom.FILE_NAME,
                    buildMeetingRoom(MeetingRoomsConstants.PortlandRoom.CALENDAR_ID,
                            MeetingRoomsConstants.PortlandRoom.NAME,
                            MeetingRoomsConstants.PortlandRoom.FILE_NAME));

            meetingRooms.put(MeetingRoomsConstants.SeattleRoom.FILE_NAME,
                    buildMeetingRoom(MeetingRoomsConstants.SeattleRoom.CALENDAR_ID,
                            MeetingRoomsConstants.SeattleRoom.NAME,
                            MeetingRoomsConstants.SeattleRoom.FILE_NAME));
        }

        private static MeetingRoom buildMeetingRoom(String calendarId, String name, String fileName) {
            return MeetingRoom.builder()
                    .calendarId(calendarId)
                    .name(name)
                    .fileName(fileName)
                    .build();
        }

    }
}