package attendance.domain.service;

import template.global.util.Parser;

public class MainService {

    private final Parser<String> stringParser;

    public MainService(Parser<String> stringParser) {
        this.stringParser = stringParser;
    }
}
