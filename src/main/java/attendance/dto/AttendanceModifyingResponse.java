package attendance.dto;

import attendance.domain.model.AttendanceStatus;
import attendance.domain.model.CustomDayOfWeek;

import java.time.LocalDate;
import java.time.LocalTime;

public record AttendanceModifyingResponse(
        int month,
        int day,
        String dayOfWeek,
        int previousHour,
        int previousMinute,
        String previousStatus,

        int currentHour,
        int currentMinute,
        String currentStatus
) {
    public static AttendanceModifyingResponse of(
            LocalDate date,
            LocalTime previousTime,
            AttendanceStatus previousStatus,
            LocalTime currentTime,
            AttendanceStatus currentStatus
    ) {
        return new AttendanceModifyingResponse(
                date.getMonthValue(),
                date.getDayOfMonth(),
                CustomDayOfWeek.getKoreaName(date.getDayOfWeek()),
                previousTime.getHour(),
                previousTime.getMinute(),
                previousStatus.getName(),
                currentTime.getHour(),
                currentTime.getMinute(),
                currentStatus.getName()
        );
    }

    @Override
    public String toString() {
        return String.format("%d월 %02d일 %s요일 %02d:%02d (%s) -> %02d:%02d (%s) 수정 완료!",
                month, day, dayOfWeek, previousHour, previousMinute, previousStatus, currentHour, currentMinute, currentStatus);
    }
}
