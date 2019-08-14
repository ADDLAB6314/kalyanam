package com.ing.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.matrimony.dto.UserDto;
import com.ing.matrimony.dto.UserResponseDto;
import com.ing.matrimony.service.UserService;

@RestController
@CrossOrigin(allowedHeaders = { "/", "*" }, origins = { "*", "/" })
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserResponseDto> register(@RequestBody UserDto userDto){
		UserResponseDto responseUserDto = userService.register(userDto);
		return new ResponseEntity<>(responseUserDto,HttpStatus.CREATED);
	}

}
