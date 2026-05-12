package org.example.jobseekingsystem_lab10.Repository;

import org.example.jobseekingsystem_lab10.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.id=?1 ")
    User findUserById(Integer id);



}
