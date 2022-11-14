package com.javassem.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("getBoardList.do")
	public void getBoardList(String searchCondition, String searchKeyword, Model m) {
//		System.out.println("searchCondition: " + searchCondition);
//		System.out.println("searchKeyword: " + searchKeyword);
		
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		List<BoardVO> list = boardService.getBoardList(map);
		m.addAttribute("boardList", list);
	}

	@RequestMapping("insertBoard.do")
	public void insertBoard() {

	}

	@RequestMapping("saveBoard.do")
	public String saveBoard(BoardVO boardVO) {
		/*
		 * System.out.println(boardVO.getTitle());
		 * System.out.println(boardVO.getWriter());
		 * System.out.println(boardVO.getContent());
		 */
		boardService.insertBoard(boardVO);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("getBoard.do")
	public void getBoard(BoardVO boardVO, Model m) {
		BoardVO resultVO = boardService.getBoard(boardVO);
		m.addAttribute("board", resultVO);
	}

	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO boardVO) {
		boardService.deleteBoard(boardVO);
		return "redirect:getBoardList.do";
	}
	// 컨트롤러 테스트 함수
	@RequestMapping("test.do")
	public void test() {
		System.out.println("test.do요청 확인");
	}

}
