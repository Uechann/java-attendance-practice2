package attendance.domain.service;

import attendance.domain.model.Attendance;
import attendance.domain.model.Crew;
import attendance.domain.repository.AttendanceRepository;
import attendance.domain.repository.CrewRepository;
import attendance.global.util.Parser;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FileService {

    private final Parser<String> stringParser;
    private final CrewRepository crewRepository;
    private final AttendanceRepository attendanceRepository;

    public FileService(Parser<String> stringParser, CrewRepository crewRepository, AttendanceRepository attendanceRepository) {
        this.stringParser = stringParser;
        this.crewRepository = crewRepository;
        this.attendanceRepository = attendanceRepository;
    }

    public void initializeCrew() {
        File attendances = new File("src/main/resources/attendances.csv");

        try (BufferedReader reader = new BufferedReader(new FileReader(attendances))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("nickname")) continue;
                // 쿠키,2024-12-13 10:08

                List<String> nameAndDateTime = stringParser.parse(line, ",");
                String name = nameAndDateTime.get(0);
                Crew crew = crewRepository.findByName(name)
                        .orElseGet(() -> Crew.of(name));

                String dateTime = nameAndDateTime.get(1);
                List<String> dateAndTime = stringParser.parse(dateTime, " ");
                String date = dateAndTime.get(0);
                String time = dateAndTime.get(1);
                LocalDate localDate = LocalDate.parse(date);
                LocalTime localTime = LocalTime.parse(time);
                attendanceRepository.save(Attendance.of(crew, localDate, localTime));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
