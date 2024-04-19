package server.sopt.coronainline.controller.error;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import server.sopt.coronainline.constant.ErrorCode;
import server.sopt.coronainline.dto.ApiErrorResponse;

import java.util.Map;

@Controller
public class BaseErrorController implements ErrorController {
    @RequestMapping(value = "error",produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHTML(HttpServletResponse response) {
        HttpStatus status = HttpStatus.valueOf(response.getStatus());
        ErrorCode errorCode = status.is4xxClientError() ? ErrorCode.BAD_REQUEST : ErrorCode.VALIDATION_ERROR;

        //index.html을 찾을수없어 노란줄
        return new ModelAndView(
                "error",
                Map.of(
                        "statusCodee", status.value(),
                        "errorCode", errorCode,
                        "message", errorCode.getMessage(status.getReasonPhrase())
                ), status
        );
    }
    @RequestMapping("error")
    public ResponseEntity<ApiErrorResponse> error(HttpServletResponse response) {
        HttpStatus status = HttpStatus.valueOf(response.getStatus());
        ErrorCode errorCode = status.is4xxClientError() ? ErrorCode.BAD_REQUEST : ErrorCode.VALIDATION_ERROR;

        //index.html을 찾을수없어 노란줄
        return ResponseEntity
                .status(status)
                .body(ApiErrorResponse.of(
                        false,
                        errorCode
                ));
    }

}
