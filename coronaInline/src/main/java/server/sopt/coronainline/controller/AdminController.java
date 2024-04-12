package server.sopt.coronainline.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @GetMapping("/places")
    public String adminPlaces(){
        return "admin/place";
    }
    @GetMapping("/places/{placeId}")
    public String adminPlaceDetail(@PathVariable Integer placeId){
        return "admin/place-detail";
    }
    @GetMapping("/places/events")
    public String adminEvent(){
        return "admin/place-event";
    }

    @GetMapping("/places/events/{eventId}")
    public String adminEventDetail(@PathVariable Integer eventId) {
        return "admin/place-event-detail";
    }



}
