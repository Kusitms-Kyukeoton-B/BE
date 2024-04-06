package com.kyukeoton_b.kyukeotonB_be.domain.dopamine.service;

import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.PostType;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.request.PostRequest;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response.GetTalkPostResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response.PostListResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.dto.response.PostResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.exception.PostException;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.repository.LikeRepository;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.repository.PostRepository;
import com.kyukeoton_b.kyukeotonB_be.domain.s3.AmazonS3Manager;
import com.kyukeoton_b.kyukeotonB_be.domain.s3.Uuid;
import com.kyukeoton_b.kyukeotonB_be.domain.s3.UuidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.kyukeoton_b.kyukeotonB_be.global.status.ErrorStatus.POST_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final AmazonS3Manager amazonS3Manager;
    private final UuidRepository uuidRepository;

    public PostListResponse findDochinZZalList() {
        List<Post> postList = postRepository.findAll();
        List<Post> byPostTypeNot = postRepository.findByPostTypeNot(PostType.TALK);
        return PostListResponse.of(postList);
    }

    public PostListResponse getDochinZZalRank() {
//        likeRepsitory.findTop3ByOrderByCountDesc();
        Pageable topThree = PageRequest.of(0, 3);
//        Pageable topThree = PageRequest.of(0, 3, Sort.unsorted());
        List<Post> topThreePosts = likeRepository.findTop3ByOrderByCountDesc(topThree);
        return PostListResponse.of(topThreePosts);
    }


    public PostResponse findDochinZZal(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostException(POST_NOT_FOUND));
        return PostResponse.of(post);
    }

    @Transactional
    public void createDochinZZal(PostRequest postRequest, MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        Uuid savedUuid = uuidRepository.save(Uuid.builder()
                .uuid(uuid).build());

//        String imageUrl = amazonS3Manager.uploadFile(, file);
        Post post = PostRequest.toEntity(postRequest);
        post.setDopamine(null);
//        post.setPostType(PostType.IMAGE);
        postRepository.save(post);
    }


    /**
     * 1. 도파밍 토크 전체 조회
     */
    public List<GetTalkPostResponse> getAllTalkPosts() {
        List<Post> posts = postRepository.findByPostType(PostType.TALK);
        System.out.println("posts = " + posts);
        List<GetTalkPostResponse> getTalkPostResponses = new ArrayList<>();
        for (Post post : posts) {
            GetTalkPostResponse getTalkPostResponse = GetTalkPostResponse.builder()
                    .questionTitle(post.getQuestionTitle())
                    .leftQuestion(post.getLeftQuestion())
                    .rightQuestion(post.getRightQuestion())
                    .talkCategory(post.getTalkCategory())
                    .build();
            getTalkPostResponses.add(getTalkPostResponse);
        }
        return getTalkPostResponses;
    }

    public GetTalkPostResponse getTalkPostById(Long postId) {
        Post post = postRepository.findByIdAndPostType(postId, PostType.TALK);
        GetTalkPostResponse getTalkPostResponse = GetTalkPostResponse.builder()
                .questionTitle(post.getQuestionTitle())
                .leftQuestion(post.getLeftQuestion())
                .rightQuestion(post.getRightQuestion())
                .talkCategory(post.getTalkCategory())
                .build();
        return getTalkPostResponse;
    }

    public Post createArticle(Post post) {
        return postRepository.save(post);
    }


}
