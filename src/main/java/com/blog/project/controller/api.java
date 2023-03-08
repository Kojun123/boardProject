package com.blog.project.controller;


import com.blog.project.dto.board.BoardDto;
import com.blog.project.service.BoardService;
import com.blog.project.service.CommentService;
import com.blog.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class api {

    private final BoardService boardService;
    private final UserService userService;
    private final CommentService commentService;

    @GetMapping("/api/board") // 게시글 리스트 페이지
    public Page<BoardDto> boardList(Model model, @RequestParam(value = "page", defaultValue = "0")Integer page) {
        return boardService.getBoardList(page);
    }

}
