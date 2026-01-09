package attendance.global.validator;

import attendance.domain.model.CustomDayOfWeek;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDateTime;
import java.util.Date;

import static attendance.global.constant.Pattern.*;
import static attendance.global.exception.ErrorMessage.INVALID_FUTURE_DATE;
import static attendance.global.exception.ErrorMessage.INVALID_INPUT_PATTERN;

public class InputValidator {

    public static void validateFunction(String input) {
        if (!input.matches(FUNCTION)) {
            throw new IllegalArgumentException(INVALID_INPUT_PATTERN.getMessage());
        }

        // 등교일 검증
        if (input.equals("1") || input.equals("2")) {
            LocalDateTime now = DateTimes.now();
            String dayOfWeek = CustomDayOfWeek.getKoreaName(now.getDayOfWeek());
            if (dayOfWeek.equals("토") || dayOfWeek.equals("일")) {
                throw new IllegalArgumentException(String.format("[ERROR] %s월 %s일 %s요일은 등교일이 아닙니다.", now.getMonthValue(), now.getDayOfMonth(), dayOfWeek));
            }

        }
    }


    public static void validateNickname(String input) {
        if (!input.matches(CREW_NAME)) {
            throw new IllegalArgumentException(INVALID_INPUT_PATTERN.getMessage());
        }
    }

    public static void validateTime(String input) {
        if (!input.matches(INPUT_TIME_PATTERN)) {
            throw new IllegalArgumentException(INVALID_INPUT_PATTERN.getMessage());
        }
    }

    public static void validateDate(String input) {
        if (!input.matches(DAY_OF_MONTH_PATTERN)) {
            throw new IllegalArgumentException(INVALID_INPUT_PATTERN.getMessage());
        }

        // 미래 시간일 경우 오류
        if (Integer.parseInt(input) > DateTimes.now().getDayOfMonth()) {
            throw new IllegalArgumentException(INVALID_FUTURE_DATE.getMessage());
        }
    }
}
