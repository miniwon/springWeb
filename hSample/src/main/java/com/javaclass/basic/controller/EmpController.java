package com.javaclass.basic.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.basic.domain.EmpVO;
import com.javaclass.basic.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService empService;
	
	// Model은 함수의 입력매개변수에 들어가지만 어딘가에서 받는 게 아니라 View페이지로 보내는 것
	@RequestMapping("empSelect.do")
	public String empSelect(Model m) {
		List<EmpVO> list = empService.empSelect();
		m.addAttribute("result", list);
		return "empSelect";
	}
	
	@RequestMapping("empDept.do")
	public void empDept(Model m) {
		List<HashMap> result = empService.empDept();
		m.addAttribute("result", result);
		for(HashMap map: result) {
			System.out.println(map);
		}
	}
}

/*
 * 뷰페이지 지정 방식
 * 1. ModelAndView 리턴
 * 2. String 리턴
 * 3. void인 경우 자동으로 요청명과 동일 페이지 리턴
 */
