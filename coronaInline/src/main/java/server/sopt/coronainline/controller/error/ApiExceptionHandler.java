package server.sopt.coronainline.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import server.sopt.coronainline.constant.ErrorCode;
import server.sopt.coronainline.dto.ApiErrorResponse;
import server.sopt.coronainline.exception.GeneralException;

import java.util.Map;

//RestController에 대한 controller advice

@RestControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> general(GeneralException e) {
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.getHttpStatus().is4xxClientError() ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(ApiErrorResponse.of(
                false, errorCode, errorCode.getMessage(e)
        ));
    }

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> exception(Exception e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(ApiErrorResponse.of(
                false, errorCode, errorCode.getMessage(e)
        ));
    }

}
