package com.dev.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entity.Produto;
import com.dev.backend.entity.ProdutoImagens;
import com.dev.backend.repository.ProdutoImagensRepository;
import com.dev.backend.repository.ProdutoRepository;

@Service
public class ProdutoImagensService {
	@Autowired
	ProdutoImagensRepository produtoImagensRepository;
	@Autowired
	ProdutoRepository produtoRepository;

	public List<ProdutoImagens> buscarTodos() {
		return produtoImagensRepository.findAll();
	}

/*	public List<ProdutoImagens> buscarPorProduto(Long idProduto) {
		List<ProdutoImagens> listaProdutoImagens = produtoImagensRepository.findByProdutoId(idProduto);

		for (ProdutoImagens produtoImagens : listaProdutoImagens) {
			try (InputStream in = new FileInputStream(
					"C:/Users/Poseidon/Desktop/loja virtualloja-virtual-2022/imagens/" + produtoImagens.getNome())) {
				produtoImagens.setArquivo(IOUtils.toByteArray(in));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return listaProdutoImagens;
	} */

	   public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
	        Produto produto = produtoRepository.findById(idProduto).get();
	        ProdutoImagens objeto = new ProdutoImagens();

			try {
				if (!file.isEmpty()) {
					byte[] bytes = file.getBytes();
	                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
					Path caminho = Paths
							.get("c:/imagens/" +nomeImagem );
					Files.write(caminho, bytes);
	                objeto.setNome(nomeImagem);

				}
			} catch (IOException e) {
				e.printStackTrace();
			}

	        objeto.setProduto(produto);
	        objeto.setDataCriacao(new Date());
	        objeto = produtoImagensRepository.saveAndFlush(objeto);
	        return objeto;
	    }

	public ProdutoImagens alterar(ProdutoImagens objeto) {

		objeto.setDataCriacao(new Date());
		ProdutoImagens objetoNovo = produtoImagensRepository.saveAndFlush(objeto);
		return objetoNovo;

	}

	public void deletar(Long id) {
		ProdutoImagens imagem = produtoImagensRepository.findById(id).get();
		produtoImagensRepository.delete(imagem);
	}

}
