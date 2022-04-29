package com.paradigma.sga.infrastructure.mapper;

import com.paradigma.sga.application.dto.PriceDTO;
import com.paradigma.sga.infrastructure.openAPI.dto.PriceProductRDTO;

public interface PriceInfraMapper {
	
//	@Mapping(target = "brandId", source = "brand.id")
//	@Mapping(target = "endDate", ignore = true)
//	@Mapping(target = "startDate", ignore = true)
	PriceProductRDTO priceDTOToPriceProductRDTO(PriceDTO priceDTO);
	
}
