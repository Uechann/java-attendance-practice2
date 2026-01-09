package attendance.global.config;

import attendance.controller.MainController;
import attendance.domain.model.Crew;
import attendance.domain.repository.AttendanceRepository;
import attendance.domain.repository.CrewRepository;
import attendance.domain.service.FileService;
import attendance.domain.service.MainService;
import attendance.global.util.Parser;
import attendance.global.util.StringParser;
import attendance.view.InputView;
import attendance.view.OutputView;

public final class DIConfig {

    private final CrewRepository crewRepository = new CrewRepository();
    private final AttendanceRepository attendanceRepository = new AttendanceRepository();

    public MainController mainController() {
        return new MainController(
                fileService(),
                mainService(),
                inputView(),
                outputView()
        );
    }

    public FileService fileService() {
        return new FileService(
                stringParser(),
                crewRepository(),
                attendanceRepository()
        );
    }

    public MainService mainService() {
        return new MainService(
                crewRepository,
                attendanceRepository,
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

    public CrewRepository crewRepository() {
        return crewRepository;
    }

    public AttendanceRepository attendanceRepository() {
        return attendanceRepository;
    }
}
