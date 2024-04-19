package server.sopt.coronainline.domain;

import lombok.Data;
import lombok.Getter;


import java.time.LocalDateTime;

@Data

public class AdminPlaceMap {


    private Long id;


    private Admin admin;


    private Place place;


    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;




}