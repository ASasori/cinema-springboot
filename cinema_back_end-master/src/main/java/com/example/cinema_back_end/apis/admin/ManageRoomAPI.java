package com.example.cinema_back_end.apis.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema_back_end.dtos.RoomDTO;
import com.example.cinema_back_end.services.IRoomService;

@RestController
@RequestMapping("/api/admin/rooms")
public class ManageRoomAPI {
	@Autowired
	private IRoomService roomSerive;
	@PostMapping
	public ResponseEntity<List<RoomDTO>> getRoomByBranch(@Param("branchId") Integer branchId){
		return new ResponseEntity<>(roomSerive.getRoomsByBranch(branchId),HttpStatus.OK);
	}
}
