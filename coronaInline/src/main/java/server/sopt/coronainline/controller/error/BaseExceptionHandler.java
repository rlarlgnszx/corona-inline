package server.sopt.coronainline.controller.error;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import server.sopt.coronainline.constant.ErrorCode;
import server.sopt.coronainline.dto.ApiErrorResponse;
import server.sopt.coronainline.exception.GeneralException;

import java.util.Map;

//view에 대한 controller advice

@Controller
public class BaseExceptionHandler {

    @ExceptionHandler
    public ModelAndView general(GeneralException e) {
        HttpStatus status = e.getErrorCode().getHttpStatus().is4xxClientError() ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorCode errorCode = e.getErrorCode();
        //index.html을 찾을수없어 노란줄
        return new ModelAndView(
                "error",
                Map.of(
                        "statusCodee", status.value(),
                        "errorCode", errorCode,
                        "message", errorCode.getMessage(e)
                ), status
        );
    }

    @ExceptionHandler
    public ModelAndView exception(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        //index.html을 찾을수없어 노란줄
        return new ModelAndView(
                "error",
                Map.of(
                        "statusCodee", status.value(),
                        "errorCode", errorCode,
                        "message", errorCode.getMessage(e)
                ), status
        );
    }
}
