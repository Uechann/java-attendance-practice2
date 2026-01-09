package attendance.dto;

import attendance.domain.model.Attendance;
import attendance.domain.model.CustomDayOfWeek;

import java.time.LocalDate;
import java.time.LocalTime;

//12월 05일 화요일 09:59 (출석)
public record AttendanceCheckResponse(
        int month,
        int day,
        String dayOfWeek,
        String hour,
        String minute,
        String status
) {
    public static AttendanceCheckResponse of(Attendance attendance) {
        LocalDate date = attendance.getDate();
        String status = attendance.getAttendanceStatus().getName();
        String dayKoreaName = CustomDayOfWeek.getKoreaName(date.getDayOfWeek());
        LocalTime time = attendance.getTime();

        String hour = "--";
        String minute = "--";
        if (attendance.getTime() != null) {
            hour = String.format("%02d",time.getHour());
            minute = String.format("%02d",time.getMinute());
        }

        return new AttendanceCheckResponse(date.getMonthValue(), date.getDayOfMonth(), dayKoreaName, hour, minute, status);
    }

    @Override
    public String toString() {
        return String.format("%d월 %02d일 %s요일 %s:%s (%s)",
                month, day, dayOfWeek, hour, minute, status);
    }
}
