package attendance.global.config;

import template.controller.MainController;
import template.domain.service.MainService;
import template.global.util.Parser;
import template.global.util.StringParser;
import template.view.InputView;
import template.view.OutputView;

public final class DIConfig {

    public MainController mainController() {
        return new MainController(
                mainService(),
                inputView(),
                outputView()
        );
    }

    public MainService mainService() {
        return new MainService(
                stringParser()
        );
    }

    public Parser<String> stringParser() {
        return new StringParser();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

}
