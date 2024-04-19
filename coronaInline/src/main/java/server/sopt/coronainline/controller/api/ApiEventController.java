package server.sopt.coronainline.controller.api;

import org.springframework.web.bind.annotation.*;
@RequestMapping("/api")
@RestController
public class ApiEventController {
    @GetMapping("/event")
    public String getEvent() {
        return "done";
    }
    @PostMapping("/event")
    public Boolean SetEvent() {
        return null;
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
