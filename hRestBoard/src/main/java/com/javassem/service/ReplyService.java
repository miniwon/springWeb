package com.javassem.service;

import java.util.List;

import com.javassem.domain.ReplyVO;

public interface ReplyService {
	// 댓글 등록
	int insertReply(ReplyVO vo);
	
	List<ReplyVO> selectAllReply();
	
	void deleteReply(int rno);
	
}
