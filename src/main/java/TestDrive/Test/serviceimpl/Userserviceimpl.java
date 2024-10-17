package TestDrive.Test.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import TestDrive.Test.model.Usermodel;
import TestDrive.Test.repo.UserRepo;
import TestDrive.Test.requestDto.UserRequestDTO;
import TestDrive.Test.responseDto.ResponseUserDTO;
import TestDrive.Test.service.Userservice;
@Service
public class Userserviceimpl implements Userservice {
	@Autowired
	UserRepo userrepo;
	
//	@Autowired
//	BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public ResponseUserDTO adduser(UserRequestDTO userRequestDTO) {
		
//		Usermodel userobj=new Usermodel();
//		userobj.setUserName(userRequestDTO.getUserName());
//		String password=passwordEncoder.encode(userRequestDTO.getPassword());
//		userobj.setPassword(password);
//		userobj.setEmailId(userRequestDTO.getEmailId());
//		userobj.setAddress(userRequestDTO.getAddress());
//		
//		Usermodel savedUser = userrepo.save(userobj);
//	    
//	    // Use ObjectMapper to map Usermodel to ResponseUserDTO
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    ResponseUserDTO responseUserDTO = objectMapper.convertValue(savedUser, ResponseUserDTO.class);
//	    
//	    return responseUserDTO;
		
		// Initialize ModelMapper
	    ModelMapper modelMapper = new ModelMapper();
	    
	    // Map UserRequestDTO to Usermodel
	    Usermodel userobj = modelMapper.map(userRequestDTO, Usermodel.class);
	    
	    // Encode the password before saving
	   // String encodedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
	    userobj.setPassword(userRequestDTO.getPassword());  // Replace the plain password with the encoded one
	    
	    // Save the Usermodel object
	    Usermodel savedUser = userrepo.save(userobj);
	    
	    // Map the saved Usermodel to ResponseUserDTO
	    ResponseUserDTO responseUserDTO = modelMapper.map(savedUser, ResponseUserDTO.class);
	    return responseUserDTO;
	}

//	@Override
//	public List<ResponseUserDTO> getAllUser() {
//	    // Initialize the list of ResponseUserDTO
//	    List<ResponseUserDTO> list = new ArrayList<>();
//	    
//	    // Retrieve all Usermodel objects from the repository
//	    List<Usermodel> listuser = userrepo.findAll();
//	    
//	    // Convert each Usermodel object to a ResponseUserDTO and add to the list
//	    for (Usermodel obj : listuser) {
//	        ResponseUserDTO responseUserDTO = new ResponseUserDTO();
//	        
//	        // Map fields from Usermodel to ResponseUserDTO (assuming manual mapping)
//	        responseUserDTO.setUserName(obj.getUserName());// Example
//	        responseUserDTO.setEmailId(obj.getEmailId()); // Example
//	        responseUserDTO.setDateofBirth(obj.getDateofBirth());
//	        responseUserDTO.setAddress(obj.getAddress()); // Example
//	        // Add other fields as necessary
//	        
//	        // Add the ResponseUserDTO to the list
//	        list.add(responseUserDTO);
//	    }
//	    
//	    // Return the populated list
//	    return list;
//	}
	
	@Override
	public List<ResponseUserDTO> getAllUser() {
	    // Retrieve all Usermodel objects from the repository
	    List<Usermodel> listuser = userrepo.findAll();
	    
	    // Use Java 8 Streams to map each Usermodel to ResponseUserDTO and collect them into a list
	    return  listuser.stream().map(obj -> {
	        ResponseUserDTO responseUserDTO = new ResponseUserDTO();
	        
	        // Map fields from Usermodel to ResponseUserDTO (assuming manual mapping)
	        responseUserDTO.setUserName(obj.getUserName()); // Example
	        responseUserDTO.setEmailId(obj.getEmailId());   // Example
	        responseUserDTO.setDateofBirth(obj.getDateofBirth()); // Example
	        responseUserDTO.setAddress(obj.getAddress());   // Example
	        // Add other fields as necessary
	        
	        return responseUserDTO;
	    }).collect(Collectors.toList());
	}

}
