package attendance.global.exception;


public enum ErrorMessage {

    ERROR_MESSAGE("[ERROR]"),

    // 공통
    INPUT_EMPTY_OR_BLANK("[ERROR] 입력값이 비어있거나 공백입니다."),
    INVALID_INPUT_PATTERN("[ERROR] 잘못된 형식을 입력하였습니다."),
    INVALID_INPUT("[ERROR] 잘못된 입력입니다. 다시 입력해주세요."),

    // 입력
    INVALID_PRODUCT_AND_QUANTITY("[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요."),
    PRODUCT_NOT_FOUND("[ERROR] 존재하지 않는 상품입니다. 다시 입력해주세요."),
    OVER_PRODUCT_STOCK("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요."),

    // 월과 요일
    INVALID_MONTH_AND_WEEKDAY("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    INVALID_WEEKDAY_KOREA_NAME("[ERROR] 해당되는 한글 요일이 없습니다."),
    WEEKDAY_NOT_FOUND("[ERROR] 해당 요일이 없습니다."),

    // 시간
    INVALID_TIME_PATTERN("[ERROR] 잘못된 시간 형식입니다."),
    INVALID_ACCESS_DATE("[ERROR] 등교일이 아닙니다."),
    INVALID_FUTURE_TIME("[ERROR] 아직 수정할 수 없습니다."),

    // 주문
    ORDER_NOT_FOUND("[ERROR] 해당 주문이 없습니다.");



    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}