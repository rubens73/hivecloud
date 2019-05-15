package br.com.hivecloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hivecloud.dto.PratosDTO;
import br.com.hivecloud.models.Pratos;
import br.com.hivecloud.service.PratosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping(value="/")
public class PratosController {

	@Autowired
	private PratosService pratosService;

	@ApiOperation(value = "Lista todos os Pratos", notes = "Lista todos os Pratos", response = Pratos.class,
			responseContainer = "List" )
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Pratos Listadas com sucesso")})
	@GetMapping("/prato")
	public List<PratosDTO> listarPratos(){
		return this.pratosService.listarPratos();
	}

	@ApiOperation(value = "Pesquisar por um Pratos", notes = "Pesquisar por um Pratos", response = Pratos.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Pratos pesquisado com sucesso")})
	@GetMapping("/prato/{id}")
	public PratosDTO listarPrato(@PathVariable String id) throws Exception{
		return this.pratosService.visualizarPratos(id);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Exclui um prato", notes = "Exclui um prato")
	@ApiResponses({@ApiResponse(code = 204, message = "Prato excluido com sucesso")})
	@DeleteMapping("/prato/{id}")
	public void excluirPrato(@PathVariable String id) {
		pratosService.excluirPratos(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Salva um Prato", notes = "Salva um Prato", response = Pratos.class )
	@ApiResponses({@ApiResponse(code = 201, message = "Prato salvo com sucesso")})
	@PostMapping("/prato")
	public PratosDTO salvarPratos(@RequestBody PratosDTO pPratoDTO){
		return pratosService.salvarPratos(pPratoDTO);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Atualizar prato", notes = "Atualizar prato")
	@ApiResponses({@ApiResponse(code = 204, message = "Prato atualização com sucesso")})
	@PutMapping("/prato")
	public PratosDTO alterarPratos(@RequestBody PratosDTO pratoDTO) throws Exception {
		PratosDTO pratoAUX = new PratosDTO();
		pratoAUX = this.pratosService.visualizarPratos(pratoDTO.getNome());
		if(pratoAUX != null) {
			return pratosService.salvarPratos(pratoDTO);
		}
		return null;
	}
}