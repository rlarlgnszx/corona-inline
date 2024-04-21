package server.sopt.coronainline.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import server.sopt.coronainline.exception.GeneralException;

@RequestMapping("/event")
@Controller
public class EventController implements ErrorController {
    @GetMapping("")
    public String event(){
        //index.html을 찾을수없어 노란줄
        return "event/index";
    }

    @GetMapping("/{eventId}")
    public String eventDetail(@PathVariable Integer eventIds){
        //index.html을 찾을수없어 노란줄

        return "event/detail";
    }
}
