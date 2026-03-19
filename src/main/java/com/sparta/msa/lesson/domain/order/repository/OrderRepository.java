package com.sparta.msa.lesson.domain.order.repository;

import com.sparta.msa.lesson.domain.order.entity.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  //List<Order> findByUser(User user);
  List<Order> findByUser_Id(Long userId);

  @Query("SELECT o FROM Order o JOIN FETCH o.user WHERE o.user.id = :userId")
  List<Order> findWithUser(@Param("userId") Long userId);
}
