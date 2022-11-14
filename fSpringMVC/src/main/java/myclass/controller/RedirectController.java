package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("insert.do")
	public String insert() {
		//***************************
		//return "select";
		//***************************
		//리다이렉팅
		return "redirect:select.do";
	}
	@RequestMapping("select.do")
	public void select(Model m) {
		m.addAttribute("info", "디비에서 넘어온 값");
	}
}
