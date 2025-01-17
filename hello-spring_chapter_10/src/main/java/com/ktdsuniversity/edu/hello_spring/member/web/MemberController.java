package com.ktdsuniversity.edu.hello_spring.member.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;
import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

import jakarta.validation.Valid;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/member/regist")
	public String viewMemberRegistPage() {
		return "member/memberregist";
	}

	@PostMapping("/member/regist")
	public String doRegistMember(@Valid RegistMemberVO registMemberVO, 
								BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("registMemberVO", registMemberVO);
			return "member/memberregist";
		}
		
		String password = registMemberVO.getPassword();
		String confirmPassword = registMemberVO.getConfirmPassword();
		
		if (!password.equals(confirmPassword)) {
			model.addAttribute("error_password", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("registMemberVO", registMemberVO);
			return "member/memberregist";
		}
		
		boolean isSuccess = this.memberService.createNewMember(registMemberVO);
		return isSuccess ? "redirect:/member/login" : "member/memberRegist";
	}

	@ResponseBody
	@GetMapping("/member/regist/available")
	public Map<String, Object> doCheckAvailableEmail( @RequestParam String email) {
		
		boolean isAvailableEmail = this.memberService.checkAvailableEmail(email);
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("email", email);
		response.put("available", isAvailableEmail);
		return response;
	}
	
	
	
	
	
	
	
	
	
}
