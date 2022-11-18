package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.ReplyVO;
import com.javassem.service.ReplyService;

import lombok.experimental.PackagePrivate;

@RestController
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@GetMapping("replies")
	public List<ReplyVO> selectAll(){
		return replyService.selectAllReply();
	}
	@DeleteMapping("replies/{rno}")
	public void delete(@PathVariable int rno) {
		System.out.println(rno + "삭제");
		replyService.deleteReply(rno);
	}
	@PostMapping("replies/new")
	public String insert(ReplyVO vo) {
		System.out.println("입력 요청: " + vo);
		int result = replyService.insertReply(vo);
		if(result == 1 ) return "success";
		else return "fail";
	}
}