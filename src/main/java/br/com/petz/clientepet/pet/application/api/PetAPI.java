package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pet")
public interface PetAPI {
	@PostMapping
	@Operation(summary = "Salva novo Pet do Cliente")
	@ResponseStatus(code = HttpStatus.CREATED)
	PetResponse postPet(@PathVariable UUID idCliente, @Valid @RequestBody PetRequest petRequest);

	@GetMapping
	@Operation(summary = "Lista todos os Pets do Cliente")
	@ResponseStatus(code = HttpStatus.OK)
	List<PetClienteListResponse> getPetsDoCliente(@PathVariable UUID idCliente);

	@GetMapping(value = "/{idPet}")
	@Operation(summary = "Busca Pet do Cliente através do ID")
	@ResponseStatus(code = HttpStatus.OK)
	PetClienteDetalhadoResponse getPetDoClienteComId(@PathVariable UUID idCliente, @PathVariable UUID idPet);

	@DeleteMapping(value = "/{idPet}")
	@Operation(summary = "Deleta Pet do Cliente através do ID")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletePetDoClienteComId(@PathVariable UUID idCliente, @PathVariable UUID idPet);

	@PatchMapping(value = "/{idPet}")
	@Operation(summary = "Edita Pet do Cliente através do ID")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchPet(@PathVariable UUID idCliente, @PathVariable UUID idPet,
			@Valid @RequestBody PetAlteracaoRequest petAlteracaoRequest);
}
