package com.example.demo.service.user;
import com.example.demo.model.Users;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Page<Users> getAllPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void add(Users sole) {
        userRepository.save(sole);
    }

    @Override
    public void update(Users sole) {
        userRepository.save(sole);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Users getById(Integer id) {
        return userRepository.getOne(id);
    }
}
