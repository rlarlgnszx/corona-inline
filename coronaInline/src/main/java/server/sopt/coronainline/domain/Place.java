package server.sopt.coronainline.domain;


import lombok.Data;
import server.sopt.coronainline.constant.PlaceType;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;


@Data
public class Place {


    private Long id;

    private PlaceType placeType;
    private String placeName;

    private String address;


    private String phoneNumber;
    private Integer capacity;


    private String memo;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    private final Set<Event> events = new LinkedHashSet<>();

    private final Set<AdminPlaceMap> adminPlaceMaps = new LinkedHashSet<>();




}