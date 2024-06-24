package br.unicesumar.service;

import br.unicesumar.model.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeitorJsonTest {

    private LeitorJson leitorJson;

    @BeforeEach
    public void setUp() {
        leitorJson = new LeitorJson("src/main/resources/veiculos.json");
    }

    @Test
    public void testFiltrarCarrosPorMarca() {
        List<Veiculo> carros = leitorJson.filtrarCarrosPorMarca("Chevrolet");
        assertNotNull(carros);
        assertTrue(carros.size() > 0);
        assertEquals("Chevrolet", carros.get(0).getMarca());
    }

    @Test
    public void testFiltrarMotosPorMarca() {
        List<Veiculo> motos = leitorJson.filtrarMotosPorMarca("Yamaha");
        assertNotNull(motos);
        assertTrue(motos.size() > 0);
        assertEquals("Yamaha", motos.get(0).getMarca());
    }

    @Test
    public void testSomarValorTotalPorMarca() {
        double valorTotal = leitorJson.somarValorTotalPorMarca("Chevrolet");
        assertTrue(valorTotal > 0);
    }

    @Test
    public void testFiltrarVeiculosMaisNovosQueAno() {
        List<Veiculo> veiculosMaisNovos = leitorJson.filtrarVeiculosMaisNovosQueAno(2020);
        assertNotNull(veiculosMaisNovos);
        assertTrue(veiculosMaisNovos.size() > 0);
        assertTrue(veiculosMaisNovos.get(0).getAno() > 2020);
    }
}
