package attendance.domain.model;

public class Crew {

    private String name;
    private int attendanceCount;
    private int lateCount;
    private int absenceCount;
    private CrewStatus crewStatus;

    private Crew(String name, int attendanceCount, int lateCount, int absenceCount, CrewStatus crewStatus) {
        this.name = name;
        this.attendanceCount = attendanceCount;
        this.lateCount = lateCount;
        this.absenceCount = absenceCount;
        this.crewStatus = crewStatus;
    }

    public static Crew of(String name) {
        return new Crew(name, 0, 0, 0, CrewStatus.NONE);
    }

    public void countAttendanceStatus(AttendanceStatus status) {
        if (status.equals(AttendanceStatus.ATTENDANCE)) {
            attendanceCount++;
        }
        if (status.equals(AttendanceStatus.LATE)) {
            lateCount++;
        }
        if (status.equals(AttendanceStatus.ABSENCE)) {
            absenceCount++;
        }

        judgeCrewStatus();
    }

    public void decreaseAttendanceStatus(AttendanceStatus status) {
        if (status.equals(AttendanceStatus.ATTENDANCE)) {
            attendanceCount--;
        }
        if (status.equals(AttendanceStatus.LATE)) {
            lateCount--;
        }
        if (status.equals(AttendanceStatus.ABSENCE)) {
            absenceCount--;
        }

        judgeCrewStatus();
    }

    private void judgeCrewStatus() {
        int totalAbsenceCount = lateCount / 3 + absenceCount;
        if (totalAbsenceCount == 2) {
            crewStatus = CrewStatus.WARNING;
        }

        if (totalAbsenceCount == 3 || totalAbsenceCount == 4 || totalAbsenceCount == 5) {
            crewStatus = CrewStatus.INTERVIEW;
        }

        if (totalAbsenceCount > 5) {
            crewStatus = CrewStatus.DISMISSAL;
        }
    }

    public String getName() {
        return name;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public int getLateCount() {
        return lateCount;
    }

    public int getAbsenceCount() {
        return absenceCount;
    }

    public CrewStatus getCrewStatus() {
        return crewStatus;
    }
}
