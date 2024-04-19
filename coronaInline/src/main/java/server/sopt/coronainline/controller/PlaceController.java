package server.sopt.coronainline.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/place")
@Controller
public class PlaceController implements ErrorController {
    @GetMapping("")
    public String place(){
        //index.html을 찾을수없어 노란줄
        return "place/index";
    }

    @GetMapping("/{placeId}")
    public String placeDetail(@PathVariable Integer placeId){
        //index.html을 찾을수없어 노란줄
        return "place/detail";
    }
}
