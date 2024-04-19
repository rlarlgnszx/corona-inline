package server.sopt.coronainline.controller.api;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.created;
import static org.springframework.web.servlet.function.ServerResponse.ok;

@Component
public class ApiPlaceHandler {
    public ServerResponse getPlaces(ServerRequest request){
        return ok().body(List.of("place1", "place2"));
    }
    public ServerResponse createPlaces(ServerRequest request){
        return created(URI.create("/api/places/1")).body(true);//TODO
    }
    public ServerResponse updatePlaces(ServerRequest request) throws Exception {
        return ok().body(true);
    }
    public ServerResponse getPlace(ServerRequest request) throws Exception {
        return ok().body(true + request.pathVariable("placeId"));
    }
    public ServerResponse deletePlaces(ServerRequest request) throws Exception {
        return ok().body(true);
    }
}
