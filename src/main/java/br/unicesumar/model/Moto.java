package br.unicesumar.model;

import java.util.List;

public class Moto {
    private List<Veiculo> novos;
    private List<Veiculo> usados;

    public List<Veiculo> getNovos() {
        return novos;
    }

    public void setNovos(List<Veiculo> novos) {
        this.novos = novos;
    }

    public List<Veiculo> getUsados() {
        return usados;
    }

    public void setUsados(List<Veiculo> usados) {
        this.usados = usados;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "novos=" + novos +
                ", usados=" + usados +
                '}';
    }
}
