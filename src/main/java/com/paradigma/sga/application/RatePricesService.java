package com.paradigma.sga.application;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.paradigma.sga.application.dto.PriceDTO;

public interface RatePricesService {

	Optional<PriceDTO> findRatePriceByProductBrandAndDate(@NotNull @Valid Long productId, @NotNull @Valid Long brandId, LocalDateTime dateIn);

	
}
