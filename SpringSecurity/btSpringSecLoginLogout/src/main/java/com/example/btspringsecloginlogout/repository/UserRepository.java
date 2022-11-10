package com.example.btspringsecloginlogout.repository;

import com.example.btspringsecloginlogout.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByTaiKhoan (String tenTK);


}
