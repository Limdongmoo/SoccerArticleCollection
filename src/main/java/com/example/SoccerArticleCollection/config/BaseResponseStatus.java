package com.example.SoccerArticleCollection.config;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {


    SUCCESS(true, 200, "요청에 성공하였습니다."),

    /**
     * match 오류
     */
    FAILED_TO_GET_MATCHES_SERVER_ERROR(false,2001,"매치 조회 서버 오류");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}

