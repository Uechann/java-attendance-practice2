package attendance.domain.repository;

import attendance.domain.model.Attendance;
import attendance.domain.model.Crew;

import java.time.LocalDate;
import java.util.*;

public class AttendanceRepository {

    private final Map<Crew, List<Attendance>> attendances = new LinkedHashMap<>();

    public Attendance save(Attendance attendance) {
        attendances.computeIfAbsent(attendance.getCrew(), crew -> new ArrayList<>()).add(attendance);
        return attendance;
    }

    public boolean isExist(Crew crew, LocalDate localDate) {
        return attendances.get(crew).stream()
                .anyMatch(attendance -> attendance.isSameDate(localDate));
    }

    public Optional<Attendance> findByCrewAndDayOfMonth(Crew crew, int day) {
        return attendances.get(crew).stream()
                .filter(attendance -> attendance.getDate().getDayOfMonth() == day)
                .findFirst();
    }

    public List<Attendance> findByCrew(Crew crew) {
        return attendances.get(crew);
    }
}
