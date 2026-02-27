package br.com.adsuema.minifood.service;

import br.com.adsuema.minifood.model.Restaurante;
import br.com.adsuema.minifood.repository.RestauranteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;


    //metodo criar restaurantes.
    public Restaurante criarRestaurante(Restaurante restaurante) {
        restaurante.setId(null);
        return restauranteRepository.save(restaurante);
    }


    //metodo atualizar restaurantes.
    public Restaurante atualizarRestaurante(Long id, Restaurante restaurante) {
        Restaurante restauranteExistente = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

        restauranteExistente.setNome(restaurante.getNome());
        restauranteExistente.setTipoComidas(restaurante.getTipoComidas());
        restauranteExistente.setEmail(restaurante.getEmail());

        return restauranteRepository.save(restauranteExistente);
    }


    //  metodo que lista todos os restaurantes.
    public List<Restaurante> listarTodosRestaurante() {
        return restauranteRepository.findAll();
    }


    //  metodo que faz a busca de um restaurante pelo id do mesmo.
    public Restaurante buscarRestaurantePorId(Long id) {
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
    }


    //metodo que deleta um restaurante através do id do mesmo
    public void deletarRestauranteId(Long id) {
        if (!restauranteRepository.existsById(id)) {
            throw new RuntimeException("Restaurante não encontrado");
        }
        restauranteRepository.deleteById(id);
    }

}
