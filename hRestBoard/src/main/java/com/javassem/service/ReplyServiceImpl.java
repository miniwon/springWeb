package com.javassem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.ReplyDAO;
import com.javassem.domain.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	public int insertReply(ReplyVO vo) {
		return replyDAO.insertReply(vo);
	}
	
	public List<ReplyVO> selectAllReply(){
		return replyDAO.selectAllReply();
	}
	
	public void deleteReply(int rno) {
		replyDAO.deleteReply(rno);
	}
}
