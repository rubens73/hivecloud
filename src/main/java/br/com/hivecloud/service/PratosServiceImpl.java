package br.com.hivecloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hivecloud.dto.PratosDTO;
import br.com.hivecloud.models.Pratos;
import br.com.hivecloud.repository.PratosRepository;

@Service
public class PratosServiceImpl implements PratosService {

	@Autowired
	private PratosRepository pratosRepository;

	@Override
	public List<PratosDTO> listarPratos() {
		List<Pratos> pratos = this.pratosRepository.findAll();
		List<PratosDTO> pratosDTO = new ArrayList<PratosDTO>();

		for (Pratos prato : pratos) {
			pratosDTO.add(prato.converterParaDTO());
		}

		return pratosDTO;
	}

	@Override
	public PratosDTO visualizarPratos(String id) {
		return this.pratosRepository.findById(id).get().converterParaDTO();
	}

	@Override
	public void excluirPratos(String id) {
		this.pratosRepository.deleteById(id);
	}

	public PratosDTO salvarPratos(PratosDTO pPratosDTO) {
		PratosDTO pratosValido = new PratosDTO();
		CriarArquivo ca = new CriarArquivo();
		
		try {
			pratosValido = this.validarPrato(pPratosDTO);
			ca.criarArquivoTxt(pPratosDTO.getNome(), pPratosDTO.toString());
			return this.pratosRepository.save(pratosValido.converterParaObjeto()).converterParaDTO();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pratosValido;
	}

	private PratosDTO validarPrato(PratosDTO pPratosDTO) throws Exception {
		if(pPratosDTO.getNome().isEmpty()) {
			throw new Exception("APagar");
		}

//		for(int i=0;i<pPratosDTO.getAcompanhamentos().length;i++) {
//			if(pPratosDTO.getAcompanhamentos()[i] == "") {
//				throw new Exception("APagar");
//			}
//		}

		if(pPratosDTO.getPreco().intValue() <= 0) {
			throw new Exception("APagar");
		}
		return pPratosDTO;
	}
}
