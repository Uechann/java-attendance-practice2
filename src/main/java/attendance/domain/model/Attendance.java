package attendance.domain.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

//  - 출석
//    - 크루
//    - Date
//    - Time
//    - 출석 상태(출석, 지각, 결석)
public class Attendance {
    private Crew crew;
    private LocalDate date;
    private LocalTime time;
    private AttendanceStatus attendanceStatus;

    private Attendance(Crew crew, LocalDate date, LocalTime time, AttendanceStatus attendanceStatus) {
        this.crew = crew;
        this.date = date;
        this.time = time;
        this.attendanceStatus = attendanceStatus;
    }

    public static Attendance of(Crew crew, LocalDate localDate, LocalTime localTime) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        AttendanceStatus status = judgeAttendanceStatus(crew, dayOfWeek, localTime);
        return new Attendance(crew, localDate, localTime, status);
    }

    // 시간 수정 -> 출석 상태 변경
    public void modifyTime(LocalTime time) {
        this.time = time;
        this.attendanceStatus = judgeAttendanceStatus(crew, date.getDayOfWeek(), time);
        crew.decreaseAttendanceStatus(attendanceStatus);
        crew.countAttendanceStatus(attendanceStatus);
    }

    private static AttendanceStatus judgeAttendanceStatus(Crew crew, DayOfWeek dayOfWeek, LocalTime localTime) {
        // TODO: 출석 규칙 클래스 분리
        AttendanceStatus status= AttendanceStatus.ATTENDANCE;
        if (dayOfWeek.equals(DayOfWeek.MONDAY)) {
            if (localTime.isAfter(LocalTime.of(13, 5)) && localTime.isBefore(LocalTime.of(13, 30))) {
                status = AttendanceStatus.LATE;
            }
            if (localTime.isAfter(LocalTime.of(13, 30))) {
                status= AttendanceStatus.ABSENCE;
            }
        }

        if (dayOfWeek.equals(DayOfWeek.TUESDAY) || dayOfWeek.equals(DayOfWeek.WEDNESDAY)
        || dayOfWeek.equals(DayOfWeek.THURSDAY) || dayOfWeek.equals(DayOfWeek.FRIDAY)) {
            if (localTime.isAfter(LocalTime.of(10, 5)) && localTime.isBefore(LocalTime.of(10, 30))) {
                status= AttendanceStatus.LATE;
            }
            if (localTime.isAfter(LocalTime.of(10, 30))) {
                status= AttendanceStatus.ABSENCE;
            }
        }

        crew.countAttendanceStatus(status);
        return status;
    }

    public Crew getCrew() {
        return crew;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public AttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }

    public boolean isSameDate(LocalDate localDate) {
        return date.equals(localDate);
    }
}
