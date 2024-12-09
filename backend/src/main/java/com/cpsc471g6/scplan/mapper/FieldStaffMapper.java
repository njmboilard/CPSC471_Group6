package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.FieldStaffDto;
import com.cpsc471g6.scplan.entity.Employee;
import com.cpsc471g6.scplan.entity.FieldStaff;

public class FieldStaffMapper {
	public static FieldStaffDto mapToFieldStaffDto(FieldStaff fieldStaff) {
		return new FieldStaffDto(
				fieldStaff.getEmployee().getId(),       // Employee ID
				fieldStaff.getPosition()                // FieldStaff position
		);
	}

	public static FieldStaff mapToFieldStaff(FieldStaffDto fieldStaffDto) {
		FieldStaff fieldStaff = new FieldStaff();
		fieldStaff.setEmployeeId(fieldStaffDto.getEmployeeId());
		fieldStaff.setPosition(fieldStaffDto.getPosition());
		return fieldStaff;
	}
}