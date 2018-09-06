package com.hackaton.endava.calendar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.hackaton.endava.calendar.model.MeetingData;
import com.hackaton.endava.calendar.model.MeetingRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        public static TextView buildCalendarTextView(View parent, String textValue) {
            TextView calendarTextView = new TextView(parent.getContext());

            calendarTextView.setWidth(parent.getWidth());
            calendarTextView.setHeight(40);
            calendarTextView.setText(textValue);
            calendarTextView.setTextSize(6);

            return calendarTextView;
        }

        public static List<MeetingData> getFakeData() {
            List<MeetingData> fakeMeetingData = new ArrayList<>();

            fakeMeetingData.add(MeetingData.builder()
                    .organizer("Matias Agüero")
                    .start("10:00")
                    .end("11:00")
                    .build());

            fakeMeetingData.add(MeetingData.builder()
                    .organizer("Nicolas Bantar")
                    .start("11:00")
                    .end("12:00")
                    .build());

            fakeMeetingData.add(MeetingData.builder()
                    .organizer("Matias Beade")
                    .start("15:00")
                    .end("16:00")
                    .build());

            fakeMeetingData.add(MeetingData.builder()
                    .organizer("Juan Manuel Helguero")
                    .start("16:00")
                    .end("17:00")
                    .build());

            fakeMeetingData.add(MeetingData.builder()
                    .organizer("Valentin Plechuc")
                    .start("17:00")
                    .end("18:00")
                    .build());

            return fakeMeetingData;
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