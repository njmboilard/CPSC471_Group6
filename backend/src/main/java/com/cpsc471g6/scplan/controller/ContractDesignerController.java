package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.ContractDesignerDto;
import com.cpsc471g6.scplan.dto.RegionDto;
import com.cpsc471g6.scplan.service.ContractDesignerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/contract-designers")

public class ContractDesignerController {
	private ContractDesignerService contractDesignerService;

	// Build Add Contract Designer REST API
	@PostMapping
	public ResponseEntity<ContractDesignerDto> createContractDesigner(@RequestBody ContractDesignerDto contractDesignerDto) {
		ContractDesignerDto savedContractDesigner = contractDesignerService.createContractDesigner(contractDesignerDto, contractDesignerDto.getContractorId());
		return new ResponseEntity<>(savedContractDesigner, HttpStatus.CREATED);
	}

	// Build Get Contract Designer REST API
	@GetMapping("{id}")
	public ResponseEntity<ContractDesignerDto> getContractDesignerById(@PathVariable("id") int contractDesignerId) {
		ContractDesignerDto contractDesignerDto = contractDesignerService.getContractDesignerById(contractDesignerId);
		return ResponseEntity.ok(contractDesignerDto);
	}

	// Build Get All Contract Designers REST API
	@GetMapping
	public ResponseEntity<List<ContractDesignerDto>> getAllContractDesigners() {
		List<ContractDesignerDto> contractDesigners = contractDesignerService.getAllContractDesigners();
		return ResponseEntity.ok(contractDesigners);
	}

	// Build Update Contract Designer REST API
	@PutMapping("{id}")
	public ResponseEntity<ContractDesignerDto> updateContractDesigner(@PathVariable("id") int contractDesignerId,
	                                                                  @RequestBody ContractDesignerDto updatedContractDesigner) {
		ContractDesignerDto contractDesignerDto = contractDesignerService.updateContractDesigner(contractDesignerId, updatedContractDesigner);
		return ResponseEntity.ok(contractDesignerDto);
	}

	// Build Delete Contract Designer REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteContractDesigner(@PathVariable("id") int contractDesignerId) {
		contractDesignerService.deleteContractDesigner(contractDesignerId);
		return ResponseEntity.ok("Contract designer " + contractDesignerId + " deleted successfully.");
	}
}
