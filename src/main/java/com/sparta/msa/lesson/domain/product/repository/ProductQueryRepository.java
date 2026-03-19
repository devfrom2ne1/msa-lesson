package com.sparta.msa.lesson.domain.product.repository;

import static com.sparta.msa.lesson.domain.product.entity.QProduct.product;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.msa.lesson.domain.product.entity.Product;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductQueryRepository {

  private final JPAQueryFactory queryFactory;

  public List<Product> findProducts(String name, Double minPrice, Double maxPrice) {
    return queryFactory
        .selectFrom(product)
        .fetch();
  }
}
