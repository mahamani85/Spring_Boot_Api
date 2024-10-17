package TestDrive.Test.service;

import java.util.List;

import TestDrive.Test.requestDto.UserRequestDTO;
import TestDrive.Test.responseDto.ResponseUserDTO;

public interface Userservice {

	ResponseUserDTO adduser(UserRequestDTO userRequestDTO);

	List<ResponseUserDTO> getAllUser();

}
