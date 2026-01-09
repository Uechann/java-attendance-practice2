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
        int hour,
        int minute,
        String status
) {
    public static AttendanceCheckResponse of(Attendance attendance) {
        LocalDate date = attendance.getDate();
        LocalTime time = attendance.getTime();
        String status = attendance.getAttendanceStatus().getName();
        String dayKoreaName = CustomDayOfWeek.getKoreaName(date.getDayOfWeek());
        return new AttendanceCheckResponse(date.getMonthValue(), date.getDayOfMonth(), dayKoreaName, time.getHour(), time.getMinute(), status);
    }

    @Override
    public String toString() {
        return String.format("%d월 %2d일 %s요일 %02d:%02d (%s)",
                month, day, dayOfWeek, hour, minute, status);
    }
}
