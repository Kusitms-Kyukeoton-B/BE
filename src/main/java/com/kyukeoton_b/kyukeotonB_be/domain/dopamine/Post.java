package com.kyukeoton_b.kyukeotonB_be.domain.dopamine;

import com.kyukeoton_b.kyukeotonB_be.domain.BaseEntity;
import com.kyukeoton_b.kyukeotonB_be.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "dopamine")
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private PostType postType;

    @Column(name = "title")
    private String title;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @Column(name = "dopamine_img")
    private String dopamineImg;

    @Column(name = "dopamine_video")
    private String dopamineVideo;

    @Column(name = "question_title")
    private String questionTitle;

    @Column(name = "left_question")
    private String leftQuestion;

    @Column(name = "right_question")
    private String rightQuestion;

    @OneToOne
    @JoinColumn(name = "post_category_id")
    private PostCategory postCategory;

    @OneToOne
    @JoinColumn(name = "talk_category_id")
    private TalkCategory talkCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setDopamine(String image) {
        this.dopamineImg = image;
    }

    public void setDopamineVideo(String video) {
        this.dopamineVideo = video;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

}
