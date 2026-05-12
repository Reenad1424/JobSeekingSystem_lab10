package org.example.jobseekingsystem_lab10.Service;

import lombok.RequiredArgsConstructor;
import org.example.jobseekingsystem_lab10.Api.ApiException;
import org.example.jobseekingsystem_lab10.Model.User;
import org.example.jobseekingsystem_lab10.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> get(){
        return userRepository.findAll();
    }

    public void add(User user){
        userRepository.save(user);
    }

    public void update(Integer id , User user){
        User oldUser =userRepository.giveMeUserById(id);

        if(oldUser==null)
            throw new ApiException("user not found");

        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        userRepository.save(oldUser);

    }

    public void delete(Integer id){
        User deleteUser=userRepository.giveMeUserById(id);

        if(deleteUser==null)
            throw new ApiException("user not found");

        userRepository.delete(deleteUser);
    }
}
