package br.unicesumar.model;

import java.util.List;

public class VeiculosContainer {
    private List<Carro> carros;
    private List<Moto> motos;

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }

    @Override
    public String toString() {
        return "VeiculosContainer{" +
                "carros=" + carros +
                ", motos=" + motos +
                '}';
    }
}
