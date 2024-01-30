package br.com.petz.clientepet.cliente.application.api;

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
@RequestMapping("/v1/cliente")
public interface ClienteAPI {
	@PostMapping
	@Operation(summary = "Salva novo Cliente")
	@ResponseStatus(code = HttpStatus.CREATED)
	ClienteResponse postCliente(@Valid @RequestBody ClienteRequest clienteRequest);
	
	@GetMapping
	@Operation(summary = "Lista todos os Clientes")
	@ResponseStatus(code = HttpStatus.OK)
	List<ClienteListResponse> getTodosClientes();
	
	@GetMapping(value = "/{idCliente}")
	@Operation(summary = "Busca Cliente através do ID")
	@ResponseStatus(code = HttpStatus.OK)
	ClienteDetalhadoResponse getClienteAtravesId(@PathVariable UUID idCliente);
	
	@DeleteMapping(value = "/{idCliente}")
	@Operation(summary = "Deleta Cliente através do ID")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaClienteAtravesId(@PathVariable UUID idCliente);
	
	@PatchMapping(value = "/{idCliente}")
	@Operation(summary = "Edita Cliente através do ID")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchAlteraCliente(@PathVariable UUID idCliente,
			@Valid @RequestBody ClienteAlteracaoRequest clienteAlteracaoRequest);
}
