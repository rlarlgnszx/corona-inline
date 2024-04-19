package server.sopt.coronainline.dto;

import lombok.*;
import server.sopt.coronainline.constant.ErrorCode;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiErrorResponse {

    private final Boolean success;
    private final Integer errorCode;
    private final String message;

    public static ApiErrorResponse of(Boolean success, Integer errorCode, String message) {
        return new ApiErrorResponse(success, errorCode, message);
    }

    public static ApiErrorResponse of(Boolean success, ErrorCode errorCode) {
        return new ApiErrorResponse(success, errorCode.getCode(), errorCode.getMessage());
    }

    public static ApiErrorResponse of(Boolean success, ErrorCode errorCode, Exception e) {
        return new ApiErrorResponse(success, errorCode.getCode(), errorCode.getMessage(e));
    }

    public static ApiErrorResponse of(Boolean success, ErrorCode errorCode, String message) {
        return new ApiErrorResponse(success, errorCode.getCode(), errorCode.getMessage(message));
    }

}