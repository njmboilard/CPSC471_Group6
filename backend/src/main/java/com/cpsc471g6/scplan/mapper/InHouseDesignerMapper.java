package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.InHouseDesignerDto;
import com.cpsc471g6.scplan.entity.InHouseDesigner;

public class InHouseDesignerMapper {

	// Convert InHouseDesigner entity to InHouseDesignerDto
	public static InHouseDesignerDto mapToInHouseDesignerDto(InHouseDesigner inHouseDesigner) {
		return new InHouseDesignerDto(
				inHouseDesigner.getEmployeeId(),
				inHouseDesigner.isPengCertification(),
				inHouseDesigner.getInitials()
		);
	}

	// Convert InHouseDesignerDto to InHouseDesigner entity
	public static InHouseDesigner mapToInHouseDesigner(InHouseDesignerDto inHouseDesignerDto) {
		InHouseDesigner inHouseDesigner = new InHouseDesigner();
		inHouseDesigner.setEmployeeId(inHouseDesignerDto.getEmployeeId());
		inHouseDesigner.setPengCertification(inHouseDesignerDto.isPengCertification());
		inHouseDesigner.setInitials(inHouseDesignerDto.getInitials());
		return inHouseDesigner;
	}
}