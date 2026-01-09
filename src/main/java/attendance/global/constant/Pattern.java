package attendance.global.constant;

public class Pattern {

    public static final String MENU = "[가-힣]+";
    public static final String QUANTITY = "[1-9][0-9]*";
    public static final String MENU_QUANTITY = "\\[+"+ MENU + "-" + QUANTITY + "\\]";

    // 상품과 수량 패턴
    public static final String PRODUCT_AND_QUANTITY_PATTERN = "^" + MENU_QUANTITY + "(," + MENU_QUANTITY + ")*" + "$";

    // Y/N 패턴
    public static final String Y_OR_N= "^[Y|N]$";

    // =======================================================================================

    // Day 일 패턴
    public static final String DAY_OF_MONTH_PATTERN = "^[1-9]|[1-2][0-9]|[3][01]$";

    // Time 시간 패턴
    public static final String INPUT_TIME_PATTERN = "^([01][0-9]|[2][0-3]):([0-5][0-9])$";

    // public static final String MENU = "[가-힣]+";
    // public static final String QUANTITY = "[1-9][0-9]*";
    // public static final String MENU_QUANTITY = MENU + "-" + QUANTITY;

    public static final String ORDER_MENU_AND_QUANTITY = "^(" +MENU_QUANTITY + ")" + "(," + MENU_QUANTITY + ")*$";

    public static final String CREW_NAME = "^[가-힣]+$";
    public static final String FUNCTION = "^[1234Q]$";


}
