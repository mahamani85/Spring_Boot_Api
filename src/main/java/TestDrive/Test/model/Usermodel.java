package TestDrive.Test.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Usermodel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	
	private String userName;
	private String password;
    private Date  dateofBirth;
    private String emailId;
    private String address;

}
