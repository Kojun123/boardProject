package com.blog.project.dto.comment;


import com.blog.project.domain.Board;
import com.blog.project.domain.Comment;
import com.blog.project.domain.Users;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private Long id;
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String boardComment;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Board board;
    private Users user;

    public Comment toEntity(){
        Comment comments = Comment.builder()
                .id(id)
                .boardComment(boardComment)
                .board(board)
                .user(user)
                .build();
        return comments;
    }

    public CommentDto toDto(Comment comment){
        CommentDto commentDto = CommentDto.builder()
                .id(id)
                .board(board)
                .board(board)
                .user(user)
                .build();
        return commentDto;
    }

    public CommentDto(Comment comment){
        this.id = comment.getId();
        this.boardComment = comment.getBoardComment();
        this.board = comment.getBoard();
        this.user = comment.getUser();
        this.createdDate = comment.getCreatedDate();
        this.modifiedDate = comment.getModifiedDate();
    }


}
