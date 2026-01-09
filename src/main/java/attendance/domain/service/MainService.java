package attendance.domain.service;

import attendance.domain.model.Attendance;
import attendance.domain.model.Crew;
import attendance.domain.repository.AttendanceRepository;
import attendance.domain.repository.CrewRepository;
import attendance.dto.AttendanceCheckResponse;
import attendance.global.util.Parser;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static attendance.global.exception.ErrorMessage.ALREADY_ATTENDANCE;
import static attendance.global.exception.ErrorMessage.CREW_NOT_FOUND;

public class MainService {

    private final CrewRepository crewRepository;
    private final AttendanceRepository attendanceRepository;
    private final Parser<String> stringParser;

    public MainService(CrewRepository crewRepository, AttendanceRepository attendanceRepository, Parser<String> stringParser) {
        this.crewRepository = crewRepository;
        this.attendanceRepository = attendanceRepository;
        this.stringParser = stringParser;
    }

    // 출석 확인
    public AttendanceCheckResponse attendanceCheck(String nickname, String attendanceTime) {
        Crew crew = crewRepository.findByName(nickname).get();
        LocalDateTime now = DateTimes.now();
        List<String> hourMinute = stringParser.parse(attendanceTime, ":");
        int hour = Integer.parseInt(hourMinute.getFirst());
        int minute = Integer.parseInt(hourMinute.get(1));

        // 오늘 출석 존재여부 확인
        if (attendanceRepository.isExist(crew, now.toLocalDate())) {
            throw new IllegalArgumentException(ALREADY_ATTENDANCE.getMessage());
        }

        Attendance attendance = attendanceRepository.save(Attendance.of(crew, now.toLocalDate(), LocalTime.of(hour, minute)));
        return AttendanceCheckResponse.of(attendance);
    }


    // 출석 수정
    public void modifyAttendance() {

    }


    // 크루별 출석 확인
    public void getAttendancesByCrew() {

    }


    // 제적 위험자 확인
    public void getCrewStatus() {

    }

    // 크루 존재 확인
    public boolean isExist(String nickname) {
        if (!crewRepository.isExist(nickname)) {
            throw new IllegalArgumentException(CREW_NOT_FOUND.getMessage());
        }
        return true;
    }
}
