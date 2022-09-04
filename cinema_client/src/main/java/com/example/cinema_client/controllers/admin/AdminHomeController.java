package com.example.cinema_client.controllers.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.cinema_client.constants.Api;
import com.example.cinema_client.models.JwtResponseDTO;
import com.example.cinema_client.models.TicketDTO;



@Controller
@RequestMapping("/admin")
public class AdminHomeController {
    @Autowired
    private RestTemplate restTemplate;
    private static final String API_GET_TICKETS = Api.baseURL+"/api/admin/tickets";

	@GetMapping
    public String displayHomePage(HttpSession session,Model model){
        // Gắn access token jwt vào header để gửi kèm request
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO)session.getAttribute("jwtResponse");
        headers.set(HttpHeaders.AUTHORIZATION,"Bearer "+jwtResponseDTO.getAccessToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);
	    ResponseEntity<TicketDTO[]> response = restTemplate.exchange(API_GET_TICKETS,HttpMethod.GET,entity,TicketDTO[].class);
	    TicketDTO[] tickets = response.getBody();
	    model.addAttribute("tickets",tickets);
        return "admin/home-admin";
    }
}
