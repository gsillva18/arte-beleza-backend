package com.project.barbershop.service;

import com.project.barbershop.model.Account;
import com.project.barbershop.model.User;
import com.project.barbershop.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public void createAccount(User user){

        Account account = new Account();
        account.setUser(user);
        account.setNumberOfCuts(0);

        repository.save(account);
    }

    public void deleteAccount(User user){
        repository.deleteAccountByUser(user);
    }

    public void increaseNumberOfCuts(User user){
        repository.increaseNumberOfCuts(user.getId());
    }
}
