package TestDrive.Test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TestDrive.Test.requestDto.UserRequestDTO;
import TestDrive.Test.responseDto.ResponseUserDTO;
import TestDrive.Test.service.Userservice;


@RestController
@RequestMapping("/user")
public class Usercontroller {
	@Autowired
	Userservice userservice;
	
	@PostMapping("/createUser")
	public ResponseUserDTO addUser(@RequestBody UserRequestDTO userRequestDTO)
	{
		return userservice.adduser(userRequestDTO);
		
	}
	 @GetMapping("/test") // Make sure this path is correctly defined
	    public String testEndpoint() {
	        return "Test endpoint reached!";
	    }
	 @GetMapping("/getAllUser")
	 public List<ResponseUserDTO> getAllUser()
	 {
		return userservice.getAllUser();
	 }
	 
	

}
