package com.hackaton.endava.calendar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

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

        public static TextView buildBusyCalendarTextView(View parent, String textValue) {
            TextView busyCalendarTextView = new TextView(parent.getContext());

            busyCalendarTextView.setWidth(parent.getWidth());
            busyCalendarTextView.setHeight(40);
            busyCalendarTextView.setText(textValue);
            busyCalendarTextView.setTextSize(6);
            busyCalendarTextView.setBackgroundColor(Color.parseColor("#de411b"));

            return busyCalendarTextView;
        }

        @SuppressLint("SetTextI18n")
        public static TextView buildEmptyCalendarTextView(View parent) {
            TextView emptyCalendarTextView = new TextView(parent.getContext());

            emptyCalendarTextView.setWidth(parent.getWidth());
            emptyCalendarTextView.setHeight(40);
            emptyCalendarTextView.setTextSize(6);
            emptyCalendarTextView.setBackgroundColor(Color.parseColor("#64666d"));
            emptyCalendarTextView.setText("FREE");
            emptyCalendarTextView.setTextColor(Color.parseColor("#ffffff"));

            return emptyCalendarTextView;
        }

    }
}