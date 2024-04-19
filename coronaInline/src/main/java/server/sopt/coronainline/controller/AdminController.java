package server.sopt.coronainline.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import server.sopt.coronainline.constant.PlaceType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @GetMapping("/places")
    public ModelAndView adminPlaces(
            PlaceType placeType,
            String placeName,
            String address
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("placeName", placeName);
        map.put("placeType", placeType);
        map.put("address", address);
        return new ModelAndView("admin/places",map);
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
