package attendance.controller;

import template.domain.service.MainService;
import template.view.InputView;
import template.view.OutputView;

public class MainController {

    private final MainService mainService;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(MainService mainService, InputView inputView, OutputView outputView) {
        this.mainService = mainService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

    }
}
