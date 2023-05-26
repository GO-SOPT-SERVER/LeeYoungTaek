package com.sopt.lyt.soptseminar.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {
    /*
     * user
     * */
    LOGIN_SUCCESS(HttpStatus.OK, "로그인에 성공했습니다."),
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입이 완료되었습니다."),

    /*
     * post
     * */
    POST_CREATED_SUCCESS(HttpStatus.CREATED, "게시글 생성 성공"),
    POSTS_GET_SUCCESS(HttpStatus.OK, "게시물 조회 성공입니다."),
    POST_UPDATE_SUCCESS(HttpStatus.OK, "게시물 수정 성공"),
    POST_DELETE_SUCCESS(HttpStatus.OK, "게시물 삭제 성공"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}