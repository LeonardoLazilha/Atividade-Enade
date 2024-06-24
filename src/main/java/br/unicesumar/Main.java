package br.unicesumar;

import br.unicesumar.model.Veiculo;
import br.unicesumar.service.LeitorJson;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("------ Atividade ENADE ------ \n");

        Scanner scanner = new Scanner(System.in);
        LeitorJson leitorJson = new LeitorJson("src/main/resources/veiculos.json");

        // Verificação se o JSON foi carregado corretamente
        if (leitorJson != null) {
            System.out.println("""
                    * * * M E N U * * *
                    1- Filtrar Carro
                    2- Filtrar Moto
                    3- Somar valor total de uma marca
                    4- Filtrar veiculos mais novo que o Ano informado
                    """);
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    System.out.println("Digite a marca do carro que deseja filtrar:");
                    String marcaCarro = scanner.nextLine();
                    List<Veiculo> carros = leitorJson.filtrarCarrosPorMarca(marcaCarro);
                    if (carros != null && !carros.isEmpty()) {
                        System.out.println("Carros da marca " + marcaCarro + ":");
                        carros.forEach(System.out::println);
                    } else {
                        System.out.println("Nenhum carro da marca " + marcaCarro + " encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("Digite a marca da moto que deseja filtrar:");
                    String marcaMoto = scanner.nextLine();
                    List<Veiculo> motos = leitorJson.filtrarMotosPorMarca(marcaMoto);
                    if (motos != null && !motos.isEmpty()) {
                        System.out.println("Motos da marca " + marcaMoto + ":");
                        motos.forEach(System.out::println);
                    } else {
                        System.out.println("Nenhuma moto da marca " + marcaMoto + " encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("Digite a marca do veículo que deseja somar o valor:");
                    String marca = scanner.nextLine();
                    double valorTotal = leitorJson.somarValorTotalPorMarca(marca);
                    System.out.println("O valor total dos veículos da marca " + marca + " é: R$ " + valorTotal);
                    break;
                case 4:
                    System.out.println("Digite o ano para filtrar os veículos mais novos:");
                    int ano = scanner.nextInt();
                    List<Veiculo> veiculosMaisNovos = leitorJson.filtrarVeiculosMaisNovosQueAno(ano);
                    if (veiculosMaisNovos != null && !veiculosMaisNovos.isEmpty()) {
                        System.out.println("Veículos mais novos que o ano " + ano + ":");
                        veiculosMaisNovos.forEach(System.out::println);
                    } else {
                        System.out.println("Nenhum veículo mais novo que o ano " + ano + " encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Erro ao carregar o JSON.");
        }

        scanner.close();
    }
}
