package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetAlteracaoRequest;
import br.com.petz.clientepet.pet.application.api.PetClienteDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.domain.Pet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
	private final ClienteService clienteService;
	private final PetRepository petRepository;
	
	@Override
	public PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetApplicationService - criaPet");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
		log.info("[finaliza] PetApplicationService - criaPet");
		return new PetResponse(pet.getIdPet());
	}

	@Override
	public List<PetClienteListResponse> buscaPetsDoClientecomID(UUID idCliente) {
		log.info("[inicia] PetApplicationService - buscaPetsDoClientecomID");
		clienteService.buscaClienteAtravesId(idCliente);
		List<Pet> petsDoCliente = petRepository.buscaPetsDoClientecomID(idCliente);
		log.info("[finaliza] PetApplicationService - buscaPetsDoClientecomID");
		return PetClienteListResponse.converte(petsDoCliente);
	}

	@Override
	public PetClienteDetalhadoResponse buscaPetsDoClientecomID(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetApplicationService - buscaPetsDoClientecomID");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.buscaPetPeloId(idPet);
		log.info("[finaliza] PetApplicationService - buscaPetsDoClientecomID");
		return new PetClienteDetalhadoResponse(pet);
	}

	@Override
	public void deletaPetDoClientecomId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetApplicationService - deletaPetDoClientecomId");		
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.buscaPetPeloId(idPet);
		petRepository.deletaPet(pet);
		log.info("[finaliza] PetApplicationService - deletaPetDoClientecomId");		
	}

	@Override
	public void alteraPetDoClientecomId(UUID idCliente, UUID idPet, PetAlteracaoRequest petAlteracaoRequest) {
		log.info("[inicia] PetApplicationService - alteraPetDoClientecomId");		
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.buscaPetPeloId(idPet);
		pet.altera(petAlteracaoRequest);
		petRepository.salvaPet(pet);
		log.info("[finaliza] PetApplicationService - alteraPetDoClientecomId");		
	}

}
