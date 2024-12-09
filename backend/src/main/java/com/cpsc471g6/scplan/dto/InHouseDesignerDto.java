package com.cpsc471g6.scplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class InHouseDesignerDto {
	private int employeeId;              // Shared primary key with Employee
	private boolean pengCertification;   // P.Eng certification status
	private String initials;             // Designer's initials (unique)
}
