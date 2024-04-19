package server.sopt.coronainline.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import server.sopt.coronainline.constant.EventType;

import java.time.LocalDateTime;
import java.util.Objects;


@Data
public class Event {
    private Long id;
    private EventType eventType;
    private Place place;
    private String eventName;
    private LocalDateTime eventStartDatetime;
    private LocalDateTime eventEndDatetime;
    private Integer currentNumberOfPeople;
    private Integer capacity;
    private String memo;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}