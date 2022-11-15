package com.javassem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;

@Controller
@RequestMapping("user")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/*
	 * @RequestMapping("userJoin.do") public void userJoin() {
	 * System.out.println("userJoin 확인"); 
	 * }
	 * 
	 * @RequestMapping("userLogin.do") public void userLogin() {
	 * System.out.println("userLogin 확인");
	 * }
	 */
	
	//@PathVariable: url에서 특정 부분을 가져와 변수로 사용하기 위한 것
	// Mapping에서 {변수명}으로 가져와 @PathVariable 달고 변수 선언
	@RequestMapping("{url}.do")
	public String userPage(@PathVariable String url) {
		return "/user/" + url;
		//"/user/"를 안쓰면 [/WEB-INF/views/userLogin.jsp]로 받아서 404오류 발생
	}
	
	/*
	 * 요청		: /user/userInsert.do
	 * 뷰페이지	:  user/userJoin_ok.jsp
	 */
	
	@RequestMapping("userInsert.do")
	public ModelAndView userInsert(MemberVO memberVO) {
//		System.out.println(memberVO.getUserName());
		
		int result = memberService.userInsert(memberVO);
		String message ="가입되지 않았습니다.";
		if(result==1) message = memberVO.getUserName() + "님 가입을 축하합니다.";
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/userJoin_ok");
		mv.addObject("message", message);
		return mv;
	}
	
	@RequestMapping("login.do")
	//*************************
	// 세션 사용 -> 인자에 HttpSession 변수 선언
	public String login(MemberVO vo, HttpSession session) {
		MemberVO result = memberService.idCheck_Login(vo);
		if(result==null || result.getUserId()==null) {
	         System.out.println("로그인 실패");
			return "/user/userLogin";
		}else {
	         System.out.println("로그인 성공");
	         //세션에 저장
	         session.setAttribute("userName", vo.getUserId());
//	         return "/user/login_ok";
	         return "/user/Main";

		}
	}
	
	@RequestMapping(value="idCheck.do", produces="application/text;charset=utf-8")
	//**************************************************************
	// 일반 요청 함수에서 String 리턴: 뷰페이지 지정
	// Ajax의 목적은 새로고침 안 하려고이기 때문에
	// 이 요청에 Ajax 통신에 의해 값을 전송해야 한다
	@ResponseBody
	// 입력매개변수로 String 써서 하나만 받아도 되고 MemberVO 안에 있는 변수라면 MemberVO 써도 된다
	public String idCheck(MemberVO vo) {
		System.out.println("idCheck.do 요청: " + vo.getUserId());
		MemberVO result = memberService.idCheck_Login(vo);
		String message = "사용 가능한 아이디입니다";
		if(result != null) message = "중복된 아이디가 있습니다";
		
		System.out.println("message: " + message);
		
		return message;
	}

	
}
