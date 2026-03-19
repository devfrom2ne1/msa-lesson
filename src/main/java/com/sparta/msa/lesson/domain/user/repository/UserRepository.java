package com.sparta.msa.lesson.domain.user.repository;

import com.sparta.msa.lesson.domain.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findById(Long id);

  Optional<User> findByEmail(String email); //null값을 받을 수도 있어서 Optional사용

  @Query("SELECT u FROM User where u.name = :name")
  Optional<User> findByEmailOrName(@Param("name") String name); //null값을 받을 수도 있어서 Optional사용


  @Query("SELECT u FROM User u JOIN FETCH u.orders WHERE u.id = :id")
  Optional<User> findUserWithOrders(@Param("id") Long id); // findBy를 안쓰고 JPA메소드를 회피했음

  // List -> findAll -> All생략가능

}
