package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 	모델(데이터)를 뷰페이지로 전송
 * 
 * 	1. ModelAndView 리턴
 * 		- addObject()
 * 	2. Model ( 호출 함수의 인자??)
 * 		- setAttribute()
 * 
 * 
 */

@Controller
@RequestMapping("/review")
public class ReviewController {
		
		@RequestMapping("modelandview.do")
		public ModelAndView test() {
			// 1. ModelAndView 뷰페이지 지정
			ModelAndView mv = new ModelAndView();
			mv.setViewName("review/void");
			mv.addObject("greeting","오늘 뭐 먹지");
			mv.addObject("friends", "희선아 정환아");
			return mv;
			
		}
		@RequestMapping("string.do")
		//****************************
		// Model: 뷰단으로 데이터를 전송하는 객체
		//		  ====> 인자에 지정
		public String test2(Model m) {
			// 2. 문자열 리턴 뷰페이지 지정
			m.addAttribute("greeting", "안녕");
			m.addAttribute("friends", "커피 마시고 싶다");
			return "review/void";
		}
		@RequestMapping("void.do")
		public void test3() {
			// 3. void 리턴
			//		-> 요청명과 동일한 뷰페이지로 자동 지정
			
		}
}
