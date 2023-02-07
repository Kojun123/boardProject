package com.blog.project;

import com.blog.project.dto.board.BoardDto;
import com.blog.project.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	BoardService boardService;

	@Test
	void test1() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%04d]", i);
			String content = "냉무";
			BoardDto boardDto = BoardDto.builder()
					.title(subject)
					.content(content)
					.build();
//			boardService.boardSave(boardDto);
		}
	}
	}


