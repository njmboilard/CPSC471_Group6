package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.ContractorDto;
import com.cpsc471g6.scplan.service.ContractorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/contractors")

public class ContractorController {
	private ContractorService contractorService;

	// Build Add Contractor REST API
	@PostMapping
	public ResponseEntity<ContractorDto> createContractor(@RequestBody ContractorDto contractorDto) {
		ContractorDto savedContractor = contractorService.createContractor(contractorDto);
		return new ResponseEntity<>(savedContractor, HttpStatus.CREATED);
	}

	// Build Get Contractor REST API
	@GetMapping("{id}")
	public ResponseEntity<ContractorDto> getContractorById(@PathVariable("id") int contractorId) {
		ContractorDto contractorDto = contractorService.getContractorById(contractorId);
		return ResponseEntity.ok(contractorDto);
	}

	// Build Get All Contractors REST API
	@GetMapping
	public ResponseEntity<List<ContractorDto>> getAllContractors() {
		List<ContractorDto> contractors = contractorService.getAllContractors();
		return ResponseEntity.ok(contractors);
	}

	// Build Update Contractor REST API
	@PutMapping("{id}")
	public ResponseEntity<ContractorDto> updateContractor(@PathVariable("id") int contractorId,
	                                                      @RequestBody ContractorDto updatedContractor) {
		ContractorDto contractorDto = contractorService.updateContractor(contractorId, updatedContractor);
		return ResponseEntity.ok(contractorDto);
	}

	// Build Delete Contractor REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteContractor(@PathVariable("id") int contractorId) {
		contractorService.deleteContractor(contractorId);
		return ResponseEntity.ok("Contractor " + contractorId + " deleted successfully.");
	}
}
