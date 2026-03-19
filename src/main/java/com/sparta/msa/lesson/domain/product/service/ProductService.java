package com.sparta.msa.lesson.domain.product.service;

import com.sparta.msa.lesson.domain.product.dto.request.ProductRequest;
import com.sparta.msa.lesson.domain.product.dto.request.ProductStockRequest;
import com.sparta.msa.lesson.domain.product.dto.response.ProductResponse;
import com.sparta.msa.lesson.domain.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<ProductResponse> getAllProducts() {
    return List.of();
  }

  public ProductResponse getProductById(Long id) {
    return null;
  }

  public ProductResponse create(ProductRequest request) {
    return ProductResponse.builder().build();
  }

  public ProductResponse update(Long id, ProductStockRequest request) {
    return ProductResponse.builder().build();
  }

  public ProductResponse updateStock(Long id, Integer stock) {
    return ProductResponse.builder().build();
  }

  public void deleteById(Long id) {

  }
}
