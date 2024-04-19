package server.sopt.coronainline.controller.api;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import server.sopt.coronainline.constant.ErrorCode;
import server.sopt.coronainline.dto.ApiErrorResponse;
import server.sopt.coronainline.exception.GeneralException;

@RequestMapping("/api")
@RestController
public class ApiEventController  {

    @GetMapping("/event")
    public String getEvent() {
        throw new GeneralException("test erorr");
//        return "done";
    }

    @PostMapping("/event")
    public Boolean SetEvent() {
        throw new RuntimeException("run time excetipdsifans");
//        return null;
    }

    @GetMapping("/event/{eventId}")
    public String getDetailEvent(@PathVariable Integer eventId) {
        return "done.";
    }

    @PutMapping("/event/{eventId}")
    public Boolean updateEvent(@PathVariable Integer eventId) {
        return null;
    }

    @DeleteMapping("/event/{eventId}")
    public Boolean deleteEvent(@PathVariable Integer eventId) {
        return null;
    }


}
