package com.kyukeoton_b.kyukeotonB_be.domain.dopamine.controller;

import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.PostType;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.request.PostRequest;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.request.PostTalkPostRequest;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response.GetTalkPostResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response.PostListResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response.PostResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.exception.PostTalkException;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.service.PostService;
import com.kyukeoton_b.kyukeotonB_be.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.kyukeoton_b.kyukeotonB_be.global.status.ErrorStatus.POST_TALK_NOT_FOUND;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping(value = "/post/file")
    public ApiResponse<PostListResponse> findDochinZZal() {
        PostListResponse dochinZZal = postService.findDochinZZalList();
        return ApiResponse.onSuccess(dochinZZal);
    }

    @GetMapping(value = "/post/rank")
    public ApiResponse<PostListResponse> getDochinZZalRank() {
        PostListResponse dochinZZalRank = postService.getDochinZZalRank();
        return ApiResponse.onSuccess(dochinZZalRank);
    }

    @GetMapping(value = "/post/file/{postId}")
    public ApiResponse<PostResponse> getDochinZZalFile(@PathVariable Long postId) {
        PostResponse dochinZZal = postService.findDochinZZal(postId);
        return ApiResponse.onSuccess(dochinZZal);
    }

    @PostMapping(value = "/post/file",consumes = "multipart/form-data")
    public ApiResponse<?> createDochinZZal(@RequestPart(value = "multipartFiles", required = false) MultipartFile multipartFile,
                                           @RequestPart(value = "postRequest",required = false) PostRequest postRequest) {

        postService.createDochinZZal(postRequest, multipartFile);
        return ApiResponse.onSuccess(null);
    }


    /**
     * 1. 도파밍 토크 전체 조회
     * @return
     */
    @GetMapping("/post/article")
    public ApiResponse<List<GetTalkPostResponse>> getAllArticles() {
        List<GetTalkPostResponse> talkPosts = postService.getAllTalkPosts();
        return ApiResponse.onSuccess(talkPosts);
    }

    @GetMapping("/post/article/{postId}")
    public ApiResponse<GetTalkPostResponse> getAnArticle(@PathVariable Long postId) {
        GetTalkPostResponse getTalkPostResponse = postService.getTalkPostById(postId);
        if(getTalkPostResponse == null) {
            throw new PostTalkException(POST_TALK_NOT_FOUND);
        }
        return ApiResponse.onSuccess(getTalkPostResponse);
    }

    @PostMapping("/post/article")
    public ApiResponse<?> createTalkPost(@RequestBody PostTalkPostRequest request) {
        Post post = Post.builder()
                .postType(PostType.TALK)
                .questionTitle(request.getQuestionTitle())
                .leftQuestion(request.getLeftQuestion())
                .rightQuestion(request.getRightQuestion())
                .user(request.getUser())
                .talkCategory(request.getTalkCategory())
                .build();

        Post createdPost = postService.createArticle(post);

        if(createdPost == null) {
            throw new PostTalkException(POST_TALK_NOT_FOUND);
        }

//        return ApiResponse.onSuccess(createdPost);
        return null;
    }



}
