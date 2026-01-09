package attendance.global.constant;

import java.util.List;

public class Constant {

    public static final int CHRISTMAS_DISCOUNT_DEFAULT_PRICE = 1_000;

    public static final List<Integer> WEEKDAYS_VALUES = List.of(1, 2, 3, 4, 7);
    public static final List<Integer> WEEKEND_VALUES = List.of(5, 6);


    public static final int WEEKDAYS_DISCOUNT_PRICE = 2_023;
    public static final int WEEKEND_DISCOUNT_PRICE = 2_023;

    public static final List<Integer> SPECIAL_DISCOUNT_DAYS = List.of(3, 10, 17, 24, 25, 31);
    public static final int SPECIAL_DISCOUNT_PRICE = 1_000;

    // 샴페인 가격
    public static final int PRESENT_DISCOUNT_PRICE = 25_000;

    public static final int EVENT_BADGE_STAR = 5_000;
    public static final int EVENT_BADGE_TREE = 10_000;
    public static final int EVENT_BADGE_SANTA = 20_000;
}
