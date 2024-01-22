package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pet")
public interface PetAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PetResponse postPet(@PathVariable UUID idCliente,
			@Valid @RequestBody PetRequest petRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<PetClienteListResponse> getPetsDoCliente(@PathVariable UUID idCliente);
}