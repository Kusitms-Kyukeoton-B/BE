package com.kyukeoton_b.kyukeotonB_be.domain.comment.service;

import com.kyukeoton_b.kyukeotonB_be.domain.comment.ReplyComment;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.dto.ReplyCommentResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.dto.ReplyTalkCommentResponse;
import com.kyukeoton_b.kyukeotonB_be.domain.comment.repository.ReplyCommentRepository;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.exception.PostException;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.kyukeoton_b.kyukeotonB_be.global.status.ErrorStatus.POST_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyCommentService {

    private final ReplyCommentRepository replyCommentRepository;
    private final PostRepository postRepository;

    public List<ReplyTalkCommentResponse> getReplyCommentsForComment(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostException(POST_NOT_FOUND));

        List<ReplyComment> replyComments = replyCommentRepository.findByCommentId(commentId);
        List<ReplyTalkCommentResponse> replyCommentResponses = new ArrayList<>();

        for (ReplyComment replyComment : replyComments) {
            ReplyTalkCommentResponse replyCommentResponse = ReplyTalkCommentResponse.builder()
                    .content(replyComment.getContent())
                    .build();
            replyCommentResponses.add(replyCommentResponse);
        }

        return replyCommentResponses;
    }

}