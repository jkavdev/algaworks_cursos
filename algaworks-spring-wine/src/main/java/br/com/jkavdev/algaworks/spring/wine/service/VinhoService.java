package br.com.jkavdev.algaworks.spring.wine.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

import br.com.jkavdev.algaworks.spring.wine.model.Vinho;
import br.com.jkavdev.algaworks.spring.wine.repository.Vinhos;

@Service
public class VinhoService {

	@Autowired
	private Vinhos vinhos;
	@Autowired
	private AmazonS3 s3Client;

	public void salvar(Vinho vinho) {
		this.vinhos.save(vinho);
	}
	
	public void adicionarFoto(Long codigo, String nome){
		Vinho vinho = vinhos.findOne(codigo);
		vinho.setFoto(nome);
		vinhos.save(vinho);
	}

	public String adicionarFoto(Long codigo, MultipartFile foto) {
		//Salva no da foto no banco
		Vinho vinho = vinhos.findOne(codigo);
		String nomeFoto = foto.getOriginalFilename();
		vinho.setFoto(nomeFoto);
		vinhos.save(vinho);

		//Salva foto no S3Ninja
		try {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType(foto.getContentType());
			metadata.setContentLength(foto.getSize());
			s3Client.putObject("wine", nomeFoto, foto.getInputStream(), metadata);
		} catch (AmazonClientException | IOException e) {
			throw new RuntimeException("Erro salvando arquivo no s3: ", e);
		}

		return nomeFoto;
	}

}
