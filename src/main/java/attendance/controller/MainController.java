package attendance.controller;


import attendance.domain.service.FileService;
import attendance.domain.service.MainService;
import attendance.dto.AttendanceCheckResponse;
import attendance.global.validator.InputValidator;
import attendance.view.InputView;
import attendance.view.OutputView;

public class MainController {


    private final FileService fileService;
    private final MainService mainService;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(FileService fileService, MainService mainService, InputView inputView, OutputView outputView) {
        this.fileService = fileService;
        this.mainService = mainService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        fileService.initializeCrew();

        outputView.outputFunction();
        String function = inputView.inputFunction();
        InputValidator.validateFunction(function);

        while (true) {
            if (function.equals("1")) { // 출석 확인
                String nickname = inputView.inputNickname();
                InputValidator.validateNickname(nickname);
                mainService.isExist(nickname);

                String attendanceTime = inputView.inputTime();
                InputValidator.validateTime(attendanceTime);
                AttendanceCheckResponse attendanceCheckResponse = mainService.attendanceCheck(nickname, attendanceTime);
                outputView.outputAttendanceCheck(attendanceCheckResponse);
            }

            if (function.equals("2")) { // 출석 수정

            }

            if (function.equals("3")) { // 크루별 조회

            }

            if (function.equals("4")) { // 제적 위험자 조회

            }

            if (function.equals("Q")) {
                break;
            }
        }
    }
}
