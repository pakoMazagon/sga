package com.paradigma.sga.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="prices")
public class Price implements Serializable{
	
	private static final long serialVersionUID = -4194405850682145505L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Brand brand;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private int priceList;
	
	private Long productId;
	
	private int priority;
	
	private double price;
	
	private String curr;

}
