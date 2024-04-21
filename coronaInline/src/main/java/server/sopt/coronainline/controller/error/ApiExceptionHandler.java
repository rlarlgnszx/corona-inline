package server.sopt.coronainline.controller.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import server.sopt.coronainline.constant.ErrorCode;
import server.sopt.coronainline.dto.ApiErrorResponse;
import server.sopt.coronainline.exception.GeneralException;

import java.util.Map;

//RestController에 대한 controller advice

@RestControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> general(GeneralException e,WebRequest request) {
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.getHttpStatus().is4xxClientError() ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR;
//        return ResponseEntity.status(status).body(ApiErrorResponse.of(
//                false, errorCode, errorCode.getMessage(e)
//        ));
        return super.handleExceptionInternal(e
                , ApiErrorResponse.of(false,errorCode.getCode(), errorCode.getMessage(e)),
                HttpHeaders.EMPTY, status, request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e,WebRequest request) {
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
//        return ResponseEntity.status(status).body(ApiErrorResponse.of(
//                false, errorCode, errorCode.getMessage(e)
//        ));
        return super.handleExceptionInternal(e
                , ApiErrorResponse.of(false,errorCode.getCode(), errorCode.getMessage(e)),
                HttpHeaders.EMPTY, status, request);
    }
    //Body만 ㅍㄴ넣어주는것!!!
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        ErrorCode errorCode = statusCode.is4xxClientError() ?
                ErrorCode.SPRING_BAD_REQUEST :
                ErrorCode.INTERNAL_ERROR;

        return super.handleExceptionInternal(ex
                , ApiErrorResponse.of(false,errorCode.getCode(), errorCode.getMessage(ex)),
                headers, statusCode, request);
    }
}
