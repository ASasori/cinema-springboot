package com.example.cinema_back_end.apis.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema_back_end.dtos.BranchDTO;
import com.example.cinema_back_end.services.IBranchService;

@RestController
@RequestMapping("/api/admin/branches")
public class ManageBranchAPI {
	@Autowired
	private IBranchService branchService;
	@GetMapping
	public ResponseEntity<List<BranchDTO>> getAllBranches(){
		return new ResponseEntity<>(branchService.findAll(),HttpStatus.OK);
	}
}
