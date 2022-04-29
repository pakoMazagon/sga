package com.paradigma.sga.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import com.paradigma.sga.domain.entity.Price;

public interface PricesService {

	List<Price> findAll();
	List<Price> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(Long productId, Long brandId, LocalDateTime dateTim);
}
