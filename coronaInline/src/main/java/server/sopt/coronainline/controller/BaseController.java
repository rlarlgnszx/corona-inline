package server.sopt.coronainline.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @GetMapping("/")
    public String root() throws  Exception{
        //index.html을 찾을수없어 노란줄
        throw new Exception("테스트 ");
//        return "index";
    }


}
