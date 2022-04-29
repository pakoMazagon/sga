package com.paradigma.sga.application;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.paradigma.sga.application.dto.PriceDTO;
import com.paradigma.sga.application.mapper.PriceMapper;
import com.paradigma.sga.domain.service.PricesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RatePriceServiceImpl implements RatePricesService {

	private final PricesService priceService;

	private final PriceMapper mapper = Mappers.getMapper(PriceMapper.class);;

	@Override
	public Optional<PriceDTO> findRatePriceByProductBrandAndDate(@NotNull @Valid Long productId, @NotNull @Valid Long brandId, LocalDateTime dateIn) {
		Optional<PriceDTO> priceDTO = priceService.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(productId, brandId, dateIn)
									.stream().map(p -> this.mapper.priceToPriceDTO(p))
									.max(Comparator.comparing(PriceDTO::getPriority));
		
		return priceDTO;
	}

}
