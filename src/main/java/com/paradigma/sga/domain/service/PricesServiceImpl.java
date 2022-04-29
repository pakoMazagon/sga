package com.paradigma.sga.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paradigma.sga.domain.entity.Price;
import com.paradigma.sga.domain.repository.PricesRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PricesServiceImpl implements PricesService {

	private final PricesRepository priceRepository;

	@Override
	public List<Price> findAll() {
		return priceRepository.findAll();
	}

	@Override
	public List<Price> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(Long productId, Long brandId, LocalDateTime dateTim) {
		return priceRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(productId, brandId, dateTim);
	}

}
