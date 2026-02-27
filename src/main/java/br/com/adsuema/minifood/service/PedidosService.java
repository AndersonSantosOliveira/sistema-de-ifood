package br.com.adsuema.minifood.service;

import br.com.adsuema.minifood.model.Pedidos;
import br.com.adsuema.minifood.model.Produtos;
import br.com.adsuema.minifood.model.Restaurante;
import br.com.adsuema.minifood.repository.PedidosRepository;
import br.com.adsuema.minifood.repository.ProdutosRepository;
import br.com.adsuema.minifood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    // Centraliza validações e associações para criação e atualização
    private Pedidos prepararPedido(Pedidos pedido) {
        // Validar e buscar restaurante
        Long idRestaurante = pedido.getRestaurante().getId();
        Restaurante restaurante = restauranteRepository.findById(idRestaurante)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

        // Validar e buscar produtos
        List<Produtos> produtosValidados = pedido.getProdutos().stream()
                .map(prod -> produtosRepository.findById(prod.getId())
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado: id " + prod.getId())))
                .toList();

        pedido.setRestaurante(restaurante);
        pedido.setProdutos(produtosValidados);

        return pedido;
    }

    // Criar Pedido
    public Pedidos criarPedido(Pedidos pedido) {
        pedido.setId(null); // Garante criação
        Pedidos pedidoPreparado = prepararPedido(pedido);
        return pedidosRepository.save(pedidoPreparado);
    }

    // Atualizar Pedido
    public Pedidos atualizarPedido(Long id, Pedidos novoPedido) {
        Pedidos pedidoExistente = pedidosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedidoExistente.setCustomer(novoPedido.getCustomer());

        // Prepara associations e validações
        novoPedido.setId(id);
        Pedidos pedidoPreparado = prepararPedido(novoPedido);

        pedidoExistente.setProdutos(pedidoPreparado.getProdutos());
        pedidoExistente.setRestaurante(pedidoPreparado.getRestaurante());

        return pedidosRepository.save(pedidoExistente);
    }

    // Listar todos pedidos
    public List<Pedidos> listarPedidos() {
        return pedidosRepository.findAll();
    }

    // Buscar pedido por id
    public Pedidos buscarPedidoPorId(Long id) {
        return pedidosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    // Deletar pedido pelo id
    public void deletarPedido(Long id) {
        if (!pedidosRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado");
        }
        pedidosRepository.deleteById(id);
    }

}
