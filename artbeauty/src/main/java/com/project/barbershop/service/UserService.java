package com.project.barbershop.service;

import com.project.barbershop.core.exceptions.UserNotFoundException;
import com.project.barbershop.dto.UserDto;
import com.project.barbershop.dto.UserUpdateDto;
import com.project.barbershop.model.User;
import com.project.barbershop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AccountService accountService;

    public User createUser(UserDto dto){
        return repository.findUserByName(dto.getName()).orElseGet(()-> createNewUser(dto.getName()));
    }
    public void updateUser(UserUpdateDto dto) throws Exception{
        User user = repository.findById(dto.getId()).orElseThrow(()->new UserNotFoundException());
        user.setName(dto.getName());
        user.setDescription(dto.getDescription());
        user.setAge(dto.getAge());
        user.setImage(dto.getImage());
        repository.save(user);
    }

    public List<User> searchUsers(){
        return repository.findAll();
    }

    public User searchUser(UserDto dto) throws Exception{
        return repository.findUserByName(dto.getName()).orElseThrow(()->new UserNotFoundException());
    }

    public void deleteUserAccount(UserDto dto) throws Exception{
        User user = searchUser(dto);
        accountService.deleteAccount(user);
        repository.delete(user);
    }

    private User createNewUser(String name){
        User newUser = new User();
        newUser.setName(name);
        repository.save(newUser);
        //Sempre que criar um novo usuário, deve-se criar uma conta para ele
        accountService.createAccount(newUser);
        return newUser;
    }

}
