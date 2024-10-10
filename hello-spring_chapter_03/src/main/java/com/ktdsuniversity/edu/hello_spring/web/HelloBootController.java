package com.ktdsuniversity.edu.hello_spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniversity.edu.hello_spring.service.HelloBootService;

@Controller // 브라우저와 통신할 수 있는 클래스.
public class HelloBootController {

	/**
	 * DI (Dependency Injection): Spring Bean Container 에 있는 인스턴스를 주입한다.
	 * 멤버변수의 타입과 Spring Bean Container에 있는 인스턴스의 타입이 같은 것만 주입한다.
	 */
	@Autowired
	private HelloBootService helloBootService;
	
//	public HelloBootController() {
//		System.out.println("@Controller가 적용된 클래스는 스프링이 직접 인스턴스로 만들어서 Bean Container에 보관합니다.");
//	}
	
	@GetMapping("/print") // http://localhost:8080/print
	public void printConsoleURL() {
		System.out.println("브라우저에 의해서 호출 되었습니다.");
	}
	
	@GetMapping("/text") // http://localhost:8080/text
	public ResponseEntity<String> printText() {
		return new ResponseEntity<>("브라우저로 텍스트를 전달합니다.", HttpStatus.OK);
		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/html") // http://localhost:8080/html
	public ResponseEntity<String> printHtml() {
		return new ResponseEntity<>("""
			<!DOCTYPE html>
			<html>
			    <head>
			        <title>Spring Test</title>
			    </head>
			    <body>
			        <h1>Hello Spring Boot!</h1>
			    </body>
			</html>
		""", HttpStatus.OK);
	}
	
	/**
	 * http://localhost:8080/jsp 로 브라우저가 요청을 하면
	 * 스프링 컨트롤러는 /WEB-INF/views/helloJsp.jsp 를 읽어와서
	 * html로 변환한 후 브라우저에게 돌려준다.
	 * @return
	 */
	@GetMapping("/jsp") // http://localhost:8080/jsp
	public String viewJSP() {
		return "helloJsp";
	}
	
	@GetMapping("/jsp2") // http://localhost:8080/jsp2
	public ModelAndView viewJSPWithModelAndView() {
		/*
		 * Model: JSP 에 보내질 데이터
		 * View: 브라우저에게 보여줄 화면
		 */
		ModelAndView view = new ModelAndView("helloJsp");
		view.addObject("applicationName", "HelloBoot!");
		return view;
	}
	
	@GetMapping("/jsp3") // http://localhost:8080/jsp3
	public String viewJSPWithModel(Model model) {
		
		String greetingMessage = this.helloBootService.getGreetingMessage();
		
		// Model: JSP 에 보내질 데이터
		model.addAttribute("applicationName", greetingMessage);
		
		return "helloJsp";
	}
}











