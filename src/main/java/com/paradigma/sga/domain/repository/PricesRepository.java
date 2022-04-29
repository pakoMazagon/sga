package com.paradigma.sga.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.paradigma.sga.domain.entity.Price;

public interface PricesRepository extends JpaRepository<Price, Long>{

	@Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brand.id = :brandId AND p.startDate <= :dateTim AND p.endDate >= :dateTim")
	List<Price> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("dateTim") LocalDateTime dateTim);
}
