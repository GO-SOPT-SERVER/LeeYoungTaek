package com.sopt.lyt.soptseminar.controller.post;

import com.sopt.lyt.soptseminar.common.dto.ApiResponseDto;
import com.sopt.lyt.soptseminar.config.jwt.JwtService;
import com.sopt.lyt.soptseminar.config.resolver.UserId;
import com.sopt.lyt.soptseminar.controller.post.dto.request.PostReqDto;
import com.sopt.lyt.soptseminar.controller.post.dto.response.PostResDto;
import com.sopt.lyt.soptseminar.exception.SuccessStatus;
import com.sopt.lyt.soptseminar.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/post")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
    private final JwtService jwtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto createPost(
            @UserId Long userId,
            @RequestBody final PostReqDto body
    ) {
        postService.createPost(userId, body);
        return ApiResponseDto.success(SuccessStatus.POST_CREATED_SUCCESS);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<List<PostResDto>> getPosts() {
        return ApiResponseDto.success(
                SuccessStatus.POSTS_GET_SUCCESS,
                postService.getPosts()
        );
    }

    @PutMapping("{postId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto updatePost(
            @UserId Long userId,
            @PathVariable final Long postId,
            @RequestBody final PostReqDto body
    ) {
        postService.updatePost(userId, postId, body);
        return ApiResponseDto.success(SuccessStatus.POST_UPDATE_SUCCESS);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto removePost(
            @UserId Long userId,
            @PathVariable final Long postId
    ) {
        postService.deletePost(userId, postId);
        return ApiResponseDto.success(SuccessStatus.POST_DELETE_SUCCESS);
    }
}