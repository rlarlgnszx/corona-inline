package server.sopt.coronainline.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Admin {
    private Long id;
    private String email;
    private String nickName;
    private String phoneNumber;
    private String password;
    private String memo;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
