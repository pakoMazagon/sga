package com.paradigma.sga.infrastructure.mapper;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.mapstruct.Mapper;

import com.paradigma.sga.application.dto.PriceDTO;
import com.paradigma.sga.infrastructure.openAPI.dto.PriceProductRDTO;

@Mapper
public class PriceInfraMapperImpl implements PriceInfraMapper{
	
	ZoneOffset offset = OffsetDateTime.now().getOffset();

	@Override
	public PriceProductRDTO priceDTOToPriceProductRDTO(PriceDTO priceDTO) {
		return new PriceProductRDTO(priceDTO.getProductId(), priceDTO.getBrand().getId(), priceDTO.getBrand().getDescription(), priceDTO.getPriceList(), priceDTO.getStartDate().atOffset(offset), priceDTO.getEndDate().atOffset(offset), priceDTO.getPrice());
	}

}
