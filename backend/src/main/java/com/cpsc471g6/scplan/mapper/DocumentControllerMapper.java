package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.DocumentControllerDto;
import com.cpsc471g6.scplan.entity.DocumentController;
import com.cpsc471g6.scplan.entity.Employee;

public class DocumentControllerMapper {
	public static DocumentControllerDto mapToDocumentControllerDto(DocumentController documentController) {
		return new DocumentControllerDto(
				documentController.getEmployee().getId(),       // Employee ID
				documentController.getRole()                    // Document Controller role
		);
	}

	public static DocumentController mapToDocumentController(DocumentControllerDto documentControllerDto) {
		DocumentController documentController = new DocumentController();
		documentController.setEmployeeId(documentControllerDto.getEmployeeId());
		documentController.setRole(documentControllerDto.getRole());
		return documentController;
	}
}