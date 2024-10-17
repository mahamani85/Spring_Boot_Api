package TestDrive.Test.requestDto;

import java.util.Date;

import lombok.Data;
@Data
public class UserRequestDTO {
	private Long id; 
	private String userName;
	private String password;
    private Date  dateofBirth;
    private String emailId;
    private String address;

}
