package com.midterm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.midterm.model.MySecuredUsers;

@Repository
public interface AppUsersRepository extends JpaRepository<MySecuredUsers, Integer> 
{
	@Query("from MySecuredUsers where username = :username")
	public MySecuredUsers getUsersByUsername(String username);
	
	@Query("from MySecuredUsers where pincode = :pincode")
	public MySecuredUsers getByPin(long pincode);
}
