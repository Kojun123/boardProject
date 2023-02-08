package com.blog.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Board extends BaseTime{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String title;
    @Column
    @Lob
    private String content;

    @Column(columnDefinition = "integer default 0",nullable = false)
    private int view;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    @OrderBy("id asc")
    private List<Comment> comment;

    @ManyToOne(fetch = FetchType.LAZY) // 여러개의 게시글은 한명의 사용자가 작성 가능하다.
    @JoinColumn(name = "userId")
    private Users user;


    @Builder
    public Board(Long id, String title, String content, List<Comment> comment, Users user,int view) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.comment = comment;
        this.view = view;
        this.user = user;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
