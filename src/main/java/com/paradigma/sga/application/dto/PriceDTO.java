package com.paradigma.sga.application.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO{

	private Long id;
	
	private BrandDTO brand;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private int priceList;
	
	private Long productId;
	
	private int priority;
	
	private double price;
	
	private String curr;

}
