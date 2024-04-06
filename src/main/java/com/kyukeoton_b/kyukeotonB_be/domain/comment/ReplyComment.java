package com.kyukeoton_b.kyukeotonB_be.domain.comment;

import com.kyukeoton_b.kyukeotonB_be.domain.BaseEntity;
import com.kyukeoton_b.kyukeotonB_be.domain.dopamine.Post;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "reply_comment")
public class ReplyComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public void setComment(Comment comment) {
        this.comment = comment;
    }


}
