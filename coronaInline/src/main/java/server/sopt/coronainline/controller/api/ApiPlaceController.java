package server.sopt.coronainline.controller.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class ApiPlaceController {
    @GetMapping("/places")
    public String getPlaces() {
        return "done";
    }

    @GetMapping("/places/{placeId}")
    public String getDetailPlaces(@PathVariable Integer placeId) {

        return "done.";
    }
    @PostMapping("/places")
    public Boolean setPlaces() {
        return null;
    }

    @PutMapping("/places/{placeId}")
    public Boolean updatePlaces(@PathVariable Integer placeId) {
        return null;
    }

    @DeleteMapping("/places/{placeId}")
    public Boolean deletePlace(@PathVariable Integer placeId) {
        return null;
    }
//    /api/places
///api/places/{place-id}
///api/places
///api/places/{place-id}
///api/places/{place-id}

}
