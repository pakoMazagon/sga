package com.paradigma.sga.infrastructure.mapper;

import com.paradigma.sga.application.dto.PriceDTO;
import com.paradigma.sga.infrastructure.openAPI.dto.PriceProductRDTO;

public interface PriceInfraMapper {
	
	PriceProductRDTO priceDTOToPriceProductRDTO(PriceDTO priceDTO);
	
}
