package com.fis.authservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.authservice.entity.User;
import com.fis.authservice.repo.UserRepo;
import com.fis.authservice.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepo userRepo;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		User userFound = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(userFound == null) {
			return new ResponseEntity<String>("Invalid user!" , HttpStatus.NOT_FOUND);
		}
		
		String token = jwtUtil.generateToken(user);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		return new ResponseEntity<String>(token,HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		
		userRepo.save(user);
		System.out.println("Info saved...");

		return new ResponseEntity<String>("Registered", HttpStatus.OK);
	}
}
