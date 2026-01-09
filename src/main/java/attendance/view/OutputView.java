package attendance.view;

import attendance.domain.model.CustomDayOfWeek;
import attendance.dto.AttendanceCheckResponse;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OutputView {

    public OutputView() {}

    public void outputFunction() {
        LocalDateTime now = DateTimes.now();
        LocalDate date = now.toLocalDate();
        String koreaName = CustomDayOfWeek.getKoreaName(date.getDayOfWeek());
        System.out.print("오늘은 " + date.getMonthValue()+"월 " + date.getDayOfMonth()+"일 " + koreaName+"요일입니다.");
        System.out.println("기능을 선택해주세요.");
        System.out.println("1. 출석 확인\n" +
                "2. 출석 수정\n" +
                "3. 크루별 출석 기록 확인\n" +
                "4. 제적 위험자 확인\n" +
                "Q. 종료");
    }

    public void outputAttendanceCheck(AttendanceCheckResponse attendanceCheckResponse) {
        System.out.println(attendanceCheckResponse.toString());
    }
}
