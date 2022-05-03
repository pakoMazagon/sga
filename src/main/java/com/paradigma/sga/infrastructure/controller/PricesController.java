package com.paradigma.sga.infrastructure.controller;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.sga.application.RatePricesManager;
import com.paradigma.sga.application.dto.PriceDTO;
import com.paradigma.sga.infrastructure.mapper.PriceInfraMapper;
import com.paradigma.sga.infrastructure.mapper.PriceInfraMapperImpl;
import com.paradigma.sga.infrastructure.openAPI.controller.PricesApi;
import com.paradigma.sga.infrastructure.openAPI.dto.PriceProductRDTO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("")
@RestController
@AllArgsConstructor
public class PricesController implements PricesApi {

	private final RatePricesManager ratePriceService;
	
	private final PriceInfraMapper mapper = Mappers.getMapper( PriceInfraMapperImpl.class );

	@Override
	public ResponseEntity<PriceProductRDTO> findPriceProductInSeason(@NotNull @Valid OffsetDateTime appDate, @NotNull @Valid Long productId,
		@NotNull @Valid Long brandId) {
		log.info("findPriceProductInSeason");
		
		LocalDateTime dateIn = appDate.toLocalDateTime();
		validateParams(dateIn, appDate);
		
		Optional<PriceDTO> pricesApply = this.ratePriceService.findRatePriceByProductBrandAndDate(productId, brandId, dateIn);
		
		PriceProductRDTO priceProductRDTO = null;
		if(pricesApply.isPresent()) {
			priceProductRDTO = mapper.priceDTOToPriceProductRDTO(pricesApply.get());
		}
		
		return ResponseEntity.ok(priceProductRDTO);
	}
	
	public boolean validateParams(LocalDateTime dateLocal, OffsetDateTime dateOffset) {
		return dateLocal.getYear() == dateOffset.getYear()
			&& dateLocal.getMonth() == dateOffset.getMonth()
				&& dateLocal.getDayOfMonth() == dateOffset.getDayOfMonth()
					&& dateLocal.getHour() == dateOffset.getHour()
						&& dateLocal.getMinute() == dateOffset.getMinute()
							&& dateLocal.getSecond() == dateOffset.getSecond();			
	}
	
}
