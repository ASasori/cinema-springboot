package com.example.cinema_back_end.apis.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema_back_end.entities.User;
import com.example.cinema_back_end.security.service.IUserService;

@RestController
@RequestMapping("/api/admin/accounts")
public class ManageAccountAPI {
	@Autowired
	private IUserService accountService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
	}
}
