package com.paradigma.sga.application.mapper;

import org.mapstruct.Mapper;

import com.paradigma.sga.application.dto.BrandDTO;
import com.paradigma.sga.application.dto.PriceDTO;
import com.paradigma.sga.domain.entity.Brand;
import com.paradigma.sga.domain.entity.Price;

@Mapper
public interface PriceMapper {
	
	Price priceDTOToPrice(PriceDTO priceDTO);
	Brand brandDTOToBrand(BrandDTO brandDTO);
	
	PriceDTO priceToPriceDTO(Price price);
	BrandDTO brandToBrandDTO(Brand brand);
	
}
