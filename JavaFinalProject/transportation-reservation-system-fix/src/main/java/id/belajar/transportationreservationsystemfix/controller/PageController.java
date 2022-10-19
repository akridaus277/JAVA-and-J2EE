package id.belajar.transportationreservationsystemfix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.belajar.transportationreservationsystemfix.entity.User;

@Controller
@RequestMapping("")
public class PageController {
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	@GetMapping("/")
	public String getLandingPage() {
		return "login";
	}
}
