package br.com.adsuema.minifood.service;

import br.com.adsuema.minifood.model.Produtos;
import br.com.adsuema.minifood.model.Restaurante;
import br.com.adsuema.minifood.repository.ProdutosRepository;
import br.com.adsuema.minifood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {
    @Autowired
    RestauranteRepository restauranteRepository;
    @Autowired
    private ProdutosRepository produtosRepository;


    //Metodo Criar produtos;
    public Produtos criarProdutos(Produtos produtos) {
        Long idRestaurente = produtos.getRestaurante().getId();
        Restaurante restaurante = restauranteRepository.findById(idRestaurente)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
        produtos.setRestaurante(restaurante);
        return produtosRepository.save(produtos);
    }

    //Metodo de atualizar Produtos
    public Produtos atualizarProdutos(Produtos produtos, Long idProdutos) {
        Produtos produtosExistentes = produtosRepository.findById(idProdutos)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtosExistentes.setNome(produtos.getNome());
        produtosExistentes.setDescricao(produtos.getDescricao());
        produtosExistentes.setPreco(produtos.getPreco());


        //mudando de restaurante
        if (produtos.getRestaurante() != null) {
            Long id = produtos.getRestaurante().getId();
            Restaurante restaurante = restauranteRepository.
                    findById(id).orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
            produtosExistentes.setRestaurante(restaurante);
        }
        return produtosRepository.save(produtosExistentes);
    }

    //metodo de listar Produtos
public List<Produtos> listarProdutos(){
        return produtosRepository.findAll();
}

    //metodo de buscar Produtos
    public Produtos listarProdutosPorId(Long id){
        return produtosRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("produto não encontrado"));
    }


    //metodo de deletar Produtos por id
    public void deletarProdutoId(Long id){
        if (!produtosRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        produtosRepository.deleteById(id);
    }

}
