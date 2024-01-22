package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetClienteDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import jakarta.validation.Valid;

public interface PetService {
	PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest);
	List<PetClienteListResponse> buscaPetsDoClientecomID(UUID idCliente);
	PetClienteDetalhadoResponse buscaPetsDoClientecomID(UUID idCliente, UUID idPet);
}
