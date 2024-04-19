package server.sopt.coronainline.controller.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
//import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

import static org.springframework.web.servlet.function.RequestPredicates.path;


@Configuration
public class ApiPlaceRouter {
    @Bean
    public RouterFunction<ServerResponse> placeRouter( ApiPlaceHandler apiPlaceHandler){
        return RouterFunctions.route()
                .nest(path("api/places")
                        , builder -> builder
                                .GET("", apiPlaceHandler::getPlaces)
                                .POST("", apiPlaceHandler::createPlaces)
                                .GET("/{placeId}", apiPlaceHandler::getPlace)
                                .PUT("/{placeId}", apiPlaceHandler::updatePlaces)
                                .DELETE("/{placeId}", apiPlaceHandler::deletePlaces)
                ).build();
    }
}
