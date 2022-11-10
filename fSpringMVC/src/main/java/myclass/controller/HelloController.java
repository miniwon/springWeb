package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("start.do")
	public ModelAndView test() {
		System.out.println("요청을 받음");
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","즐거운 하루");
		mv.setViewName("secret");
		// "WEB-INF/views/ + secret + .jsp
		return mv;
	}
}
