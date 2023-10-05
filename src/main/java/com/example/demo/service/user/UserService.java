package com.example.demo.service.user;
import com.example.demo.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<Users> getAllPage(Pageable pageable);
    void add(Users sole);
    void update(Users sole);
    void delete(Integer id);
    Users getById(Integer id);

}
