package br.com.hivecloud.service;

import java.util.List;

import br.com.hivecloud.dto.PratosDTO;

public interface PratosService {

	public List<PratosDTO> listarPratos();
	public PratosDTO visualizarPratos(String id) throws Exception;
	public void excluirPratos(String id);
	public PratosDTO salvarPratos(PratosDTO pratoDTO);

}
