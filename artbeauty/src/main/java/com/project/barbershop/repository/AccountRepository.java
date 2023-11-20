package com.project.barbershop.repository;

import com.project.barbershop.model.Account;
import com.project.barbershop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    void deleteAccountByUser(User user);

    @Query(value = "update tb_account set number_of_cuts = " +
            "case when number_of_cuts > 4 then 0 else number_of_cuts+1 end " +
            "where user_fk = :id", nativeQuery = true)
    void increaseNumberOfCuts(@Param("id") Long id);
}
