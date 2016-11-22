package br.com.jkavdev.algaworks.spring.wine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.jkavdev.algaworks.spring.wine.model.Vinho;
import br.com.jkavdev.algaworks.spring.wine.repository.Vinhos;
import br.com.jkavdev.algaworks.spring.wine.storage.FotoStorageS3;

@Service
public class VinhoService {

	@Autowired
	private Vinhos vinhos;
	@Autowired
	private FotoStorageS3 fotoStorageS3;

	public void salvar(Vinho vinho) {
		this.vinhos.save(vinho);
	}

	public String adicionarFoto(Long codigo, MultipartFile foto) {
		// Salva no da foto no banco
		Vinho vinho = vinhos.findOne(codigo);
		String nomeFoto = fotoStorageS3.salvar(foto);
		vinho.setFoto(nomeFoto);
		vinhos.save(vinho);

		return fotoStorageS3.getUrl(nomeFoto);
	}

}
