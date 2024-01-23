package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.pet.application.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {
	private final PetService petService;

	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetController - postPet");
		log.info("[idCliente] {}", idCliente);
		PetResponse pet = petService.criaPet(idCliente, petRequest);
		log.info("[finaliza] PetController - postPet");
		return pet;
	}

	@Override
	public List<PetClienteListResponse> getPetsDoCliente(UUID idCliente) {
		log.info("[inicia] PetController - getPetsDoCliente");
		log.info("[idCliente] {}", idCliente);
		List<PetClienteListResponse> petsDoCliente = petService.buscaPetsDoClientecomID(idCliente);
		log.info("[finaliza] PetController - getPetsDoCliente");
		return petsDoCliente;
	}

	@Override
	public PetClienteDetalhadoResponse getPetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - getPetDoClienteComId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		PetClienteDetalhadoResponse pet = petService.buscaPetsDoClientecomID(idCliente, idPet);
		log.info("[finaliza] PetController - getPetDoClienteComId");
		return pet;
	}

	@Override
	public void deletePetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - deletePetDoClienteComId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);		
		petService.deletaPetDoClientecomId(idCliente, idPet);
		log.info("[finaliza] PetController - deletePetDoClienteComId");
	}

	@Override
	public PetResponse patchPet(UUID idCliente, UUID idPet, @Valid PetAlteracaoRequest petRequest) {
		log.info("[inicia] PetController - patchPet");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);		
		log.info("[finaliza] PetController - patchPet");
		return null;
	}
}
