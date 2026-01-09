package attendance.dto;

import attendance.domain.model.Crew;

import java.util.List;

public record CrewAttendancesResponse(
        String nickname,
        List<AttendanceCheckResponse> attendanceCheckResponses,
        int attendanceCount,
        int lateCount,
        int absenceCount,
        String status
) {
    public static CrewAttendancesResponse of(List<AttendanceCheckResponse> attendanceCheckResponses, Crew crew) {
        return new CrewAttendancesResponse(
                crew.getName(),
                attendanceCheckResponses,
                crew.getAttendanceCount(),
                crew.getLateCount(),
                crew.getAbsenceCount(),
                crew.getCrewStatus().getName()
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("이번달 ").append(nickname).append("의 출석 기록입니다.").append("\n");

        for (AttendanceCheckResponse attendanceCheckRespone : attendanceCheckResponses) {
            sb.append(attendanceCheckRespone.toString()).append("\n");
        }

        sb.append("출석: ").append(attendanceCount).append("회").append("\n");
        sb.append("지각: ").append(lateCount).append("회").append("\n");
        sb.append("결석: ").append(absenceCount).append("회").append("\n");
        sb.append(status).append(" 대상자입니다.").append("\n");
        return sb.toString();
    }
}
