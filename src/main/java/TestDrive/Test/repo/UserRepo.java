package TestDrive.Test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TestDrive.Test.model.Usermodel;

@Repository
public interface UserRepo extends JpaRepository<Usermodel,Long> {



	

}
