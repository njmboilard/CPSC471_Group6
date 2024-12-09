package com.cpsc471g6.scplan.dto;

import com.cpsc471g6.scplan.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArchivePlanDto {
	private String chopCode;
	private BigDecimal mileage;
	private String drawingNumber;
	private LocalDate uploadDate;
	private boolean assignedStatus;
	private String archiveStatus;
}