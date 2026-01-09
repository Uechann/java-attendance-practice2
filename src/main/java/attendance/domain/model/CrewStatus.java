package attendance.domain.model;

public enum CrewStatus {
    NONE("없음", 0),
    WARNING("경고", 1),
    INTERVIEW("면담", 2),
    DISMISSAL("제적", 3);

    private String name;
    private int code;

    CrewStatus(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
