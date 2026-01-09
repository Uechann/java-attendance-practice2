package attendance;

import attendance.controller.MainController;
import attendance.global.config.DIConfig;

public class Application {
    public static void main(String[] args) {
        DIConfig config = new DIConfig();
        MainController mainController = config.mainController();
        mainController.run();
    }
}
