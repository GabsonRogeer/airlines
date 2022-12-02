package program;

import entities.Cliente;
import entities.Passagem;
import entities.Reserva;
import entities.Voo;
import services.VooService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VooService service = new VooService();
        List<Voo> voos = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            String opcao = "";
            boolean sair = false;
            System.out.println("Bem-vindo");
            do {
                System.out.println("*------------------------------------------------------------*");
                System.out.println("|0 - Sair                                                    |");
                System.out.println("|1 - Compar uma Passagem                                     |");
                System.out.println("|2 - Alterar o assento                                       |");
                System.out.println("|3 - Alterar titularidade de uma reserva                     |");
                System.out.println("|4 - Calcelar uma reserva                                    |");
                System.out.println("|5 - Imprimir lista de passageiros                           |");
                System.out.println("*------------------------------------------------------------*");

                System.out.print("Informe a opção: \n");
                opcao = sc.nextLine();

                switch (opcao) {
                    case "0" -> {
                        System.out.println("*------------------------------------------------------------*");
                        System.out.println("|ENCERRADANDO APLICAÇÃO...                                   |");
                        System.out.println("|OBRIGADO!                                                   |");
                        System.out.println("*------------------------------------------------------------*");
                        sair = true;
                    }
                    case "1" -> {
                        System.out.println("-> COMPARAR UMA PASSAGEM");
                        String origem, destino;
                        System.out.println("Qual a sua origem? ");
                        origem = sc.next();
                        System.out.println("Qual o seu destino? ");
                        destino = sc.next();
                        String nome, cpf;
                        System.out.println("Digite seu nome: ");
                        nome = sc.next();
                        System.out.println("digite seu cpf: ");
                        cpf = sc.next();
                        Voo v1 = new Voo(origem, destino);
                        Cliente c1 = new Cliente(nome, cpf);
                        Reserva r1 = new Reserva(c1);
                        v1.addReserva(r1);
                        voos.add(v1);
                        service.adicionaVoo(v1);
                        System.out.println(v1);
                        //service.listarVoo(origem, destino);
                    }
                    case "2" -> {
                        System.out.println("-> Listar voo");
                        System.out.println("Origem");
                        String origem = sc.next();

                        System.out.println("destino");
                        String destino = sc.next();

                        service.listarVoo(origem, destino);
                    }
                    case "3" -> {
                        System.out.println("-> Calcula passageiros");
                        System.out.println("Origem");
                        String origem = sc.next();

                        System.out.println("destino");
                        String destino = sc.next();

                        service.calculaPassageiros(origem, destino);
                    }
                    case "4" -> System.out.println("Função ainda não implementada");
                    case "5" -> System.out.println("Função ainda não implementada");
                    default -> {
                    }
                }
            } while (!sair);
        }
    }
}
