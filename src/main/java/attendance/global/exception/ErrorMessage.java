package attendance.global.exception;


public enum ErrorMessage {

    ERROR_MESSAGE("[ERROR]"),
    // - [ ] 기능 선택 항목, 날짜 또는 시간을 잘못된 형식으로 입력한 경우
    //  [ERROR] 잘못된 형식을 입력하였습니다.
    //- [ ] 등록되지 않은 닉네임을 입력한 경우
    //  [ERROR] 등록되지 않은 닉네임입니다.
    //- [ ] 주말 또는 공휴일에 출석을 확인하거나 수정하는 경우
    //  [ERROR] 12월 14일 토요일은 등교일이 아닙니다.
    //- [ ] 미래 날짜로 출석을 수정하는 경우
    //  [ERROR] 아직 수정할 수 없습니다.
    //- [ ] 등교 시간이 캠퍼스 운영 시간이 아닌 경우
    //  [ERROR] 캠퍼스 운영 시간에만 출석이 가능합니다.
    //- [ ] 이미 출석을 하였는데 다시 출석 확인을 하는 경우
    //  [ERROR] 이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요.
    INVALID_INPUT_PATTERN("[ERROR] 잘못된 형식을 입력하였습니다."),
    CREW_NOT_FOUND("[ERROR] 등록되지 않은 닉네임입니다."),
    INVALID_DATE("등교일이 아닙니다."),
    INVALID_FUTURE_DATE("[ERROR] 아직 수정할 수 없습니다."),
    INVALID_OPERATING_HOUR("[ERROR] 캠퍼스 운영 시간에만 출석이 가능합니다."),
    ALREADY_ATTENDANCE("[ERROR] 이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요."),
    ATTENDANCE_NOT_FOUND("[ERROR] 해당 출석이 존재하지 않습니다."),

    INVALID_WEEKDAY_KOREA_NAME("[ERROR] 유효하지 않은 요일");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}