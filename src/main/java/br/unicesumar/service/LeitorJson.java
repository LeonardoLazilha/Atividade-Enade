package br.unicesumar.service;

import br.unicesumar.model.Veiculo;
import br.unicesumar.model.VeiculosContainer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeitorJson {

    private VeiculosContainer veiculosContainer;
    private List<Veiculo> todosVeiculos;

    public LeitorJson(String caminhoArquivo) {
        this.veiculosContainer = lerArquivoJson(caminhoArquivo);
        this.todosVeiculos = new ArrayList<>();
        carregarTodosVeiculos();
    }

    public VeiculosContainer lerArquivoJson(String caminhoArquivo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File json = new File(caminhoArquivo);
            return mapper.readValue(json, VeiculosContainer.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //ADD TODOS CARROS E MOTOS A LISTA DE VEICULOS
    private void carregarTodosVeiculos() {
        if (veiculosContainer != null) {
            veiculosContainer.getCarros().forEach(carro -> {
                if (carro.getNovos() != null) {
                    carro.getNovos().forEach(veiculo -> veiculo.setTipo("Carro"));
                    todosVeiculos.addAll(carro.getNovos());
                }
                if (carro.getUsados() != null) {
                    carro.getUsados().forEach(veiculo -> veiculo.setTipo("Carro"));
                    todosVeiculos.addAll(carro.getUsados());
                }
            });
            veiculosContainer.getMotos().forEach(moto -> {
                if (moto.getNovos() != null) {
                    moto.getNovos().forEach(veiculo -> veiculo.setTipo("Moto"));
                    todosVeiculos.addAll(moto.getNovos());
                }
                if (moto.getUsados() != null) {
                    moto.getUsados().forEach(veiculo -> veiculo.setTipo("Moto"));
                    todosVeiculos.addAll(moto.getUsados());
                }
            });
        }
    }

    //FILTRAR CARRO POR MARCA
    public List<Veiculo> filtrarCarrosPorMarca(String marca) {
        return todosVeiculos.stream()
                .filter(v -> "Carro".equals(v.getTipo()) && v.getMarca().equalsIgnoreCase(marca))
                .collect(Collectors.toList());
    }

    //FILTRAR MOTO POR MARCA
    public List<Veiculo> filtrarMotosPorMarca(String marca) {
        return todosVeiculos.stream()
                .filter(v -> "Moto".equals(v.getTipo()) && v.getMarca().equalsIgnoreCase(marca))
                .collect(Collectors.toList());
    }

    //SOMAR VALOR TOTAL POR MARCA
    public double somarValorTotalPorMarca(String marca) {
        return todosVeiculos.stream()
                .filter(v -> v.getMarca().equalsIgnoreCase(marca))
                .mapToDouble(Veiculo::getValor)
                .sum();
    }

    //FILTRAR VEICULOS MAIS NOVOS QUE O ANO INFORMADO
    public List<Veiculo> filtrarVeiculosMaisNovosQueAno(int ano) {
        return todosVeiculos.stream()
                .filter(v -> v.getAno() > ano)
                .collect(Collectors.toList());
    }
}
