package com.blog.project.dto.board;

import com.blog.project.domain.Board;
import com.blog.project.domain.Comment;
import com.blog.project.domain.Users;
import com.blog.project.dto.comment.CommentDto;
import com.blog.project.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private List<CommentDto> comment;
    private int view;
    private UserDto user;


    public BoardDto(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createdDate = board.getCreatedDate();
        this.modifiedDate = board.getModifiedDate();
        this.comment =  board.getComment().stream().map(c -> new CommentDto(c)).collect(Collectors.toList());
        if(board.getUser() != null){
            this.user = board.getUser().toUserDto();
        } else if (board.getUser() == null) {
            this.user = null;
        }
        this.view = board.getView();
    }

    @Builder
    public BoardDto(Long id, String title, String content, LocalDateTime createdDate, List<CommentDto> comment,UserDto user,int view, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.comment = comment;
        this.user = user;
        this.view = view;
        this.modifiedDate = modifiedDate;
    }

    public Board toEntity(){

        if (comment == null){
            Board board = Board.builder()
                    .id(id)
                    .content(content)
                    .title(title)
                    .user(user)
                    .view(view)
                    .build();
            return board;
        }
        else {
            Board board = Board.builder()
                    .id(id)
                    .content(content)
                    .title(title)
                    .user(user)
                    .view(view)
                    .comment(comment.stream().map(c -> new Comment(c)).collect(Collectors.toList()))
                    .build();
            return board;
        }


    }

}
