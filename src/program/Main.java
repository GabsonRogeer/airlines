package program;

import entities.Cliente;
import entities.Reserva;
import entities.Voo;
import interfaces.VooInterface;
import services.VooService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    //todo: só seleciona os acentos do 1 ao 6 se os outros estiverem cheios sem custo adicional; j|\|UIJ*SA  eiujds|GV\vvb   entities.Reserva

        VooInterface vooInterface = new VooService();

        try (Scanner sc = new Scanner(System.in)) {
            String opcao;

            System.out.println("Bem-vindo");
            for (int i = 1; i > 0; i++) {
                {
                    System.out.println("*------------------------------------------------------------*");
                    System.out.println("|0 - Sair                                                    |");
                    System.out.println("|1 - Compar uma Passagem                                     |");
                    System.out.println("|2 - Alterar o assento                                       |");
                    System.out.println("|3 - Alterar titularidade de uma reserva                     |");
                    System.out.println("|4 - Calcelar uma reserva                                    |");
                    System.out.println("|5 - Imprimir lista de passageiros                           |");
                    System.out.println("*------------------------------------------------------------*");

                    System.out.print("Informe a opção: \n");
                    opcao = sc.next();

                    switch (opcao) {
                        case "0" -> {
                            System.out.println("*------------------------------------------------------------*");
                            System.out.println("|ENCERRADANDO APLICAÇÃO...                                   |");
                            System.out.println("|OBRIGADO!                                                   |");
                            System.out.println("*------------------------------------------------------------*");
                            i = -1;
                        }
                        case "1" -> {
                            System.out.println("-> COMPARAR UMA PASSAGEM");
                            System.out.println("Qual a sua origem? ");
                            String origem = sc.next().toUpperCase();
                            System.out.println("Qual o seu destino? ");
                            String destino = sc.next().toUpperCase();
                            if (origem.equals(destino)) {
                                System.out.println("A origem não pode ser igual ao destino");
                            } else {
                                System.out.printf("O Valor da sua passagem é: R$ %.2f\"",
                                        vooInterface.calculaValorPassagem(origem, destino));
                                System.out.println("\nDeseja comprar a passagem? (Y / N)");
                                char ch = sc.next().charAt(0);
                                if (ch == 'y') {
                                    String nome, cpf;
                                    System.out.println("Digite seu nome: ");
                                    nome = sc.next();
                                    System.out.println("digite seu cpf: ");
                                    cpf = sc.next();
                                    Cliente c1 = new Cliente(nome, cpf);
                                    Reserva r1 = new Reserva(c1);
                                    Voo v1 = new Voo(origem.toUpperCase(), destino.toUpperCase(), r1
                                            , vooInterface.calculaValorPassagem(origem, destino));
                                    v1.addReserva(r1);
                                    vooInterface.adicionaVoo(v1);
                                    System.out.printf(String.valueOf(v1));
                                }
                            }
                        }
                        case "2" -> {
                            try {
                                System.out.println("-> Alterar Assento");
                                System.out.println("Qual o número da reserva? ");
                                int numReserva = sc.nextInt();
                                System.out.println("Qual número do assento que você deseja? ");
                                int assento = sc.nextInt();
                                if (assento <= 6) {
                                    System.out.println("\nO assento escolhido foi o " + assento +
                                            ", Ele tem um adicional de R$ 50,00. Você deseja alterar o" +
                                            " seu assento mesmo assim?" +
                                            " (Y / N)");
                                    char ch2 = sc.next().charAt(0);
                                    if (ch2 == 'y') {
                                        vooInterface.alterarAssento(numReserva, assento);
                                        System.out.println("Assento alterado com sucesso!");
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Número de assento inválido");
                            }
                        }
                        case "3" -> {
                            System.out.println("-> Altera titularidade");
                            System.out.println("Qual o número da reserva? ");
                            int numReserva2 = sc.nextInt();
                            System.out.println("Qual o nome do novo titular?");
                            String nome = sc.next();
                            System.out.println("Qual o CPF do novo titular?");
                            String cpf = sc.next();
                            Cliente novoCliente = new Cliente(nome, cpf);
                            vooInterface.alterarTitularidade(numReserva2, novoCliente);
                            System.out.println("Titularidade alterada com sucesso!");
                        }
                        case "4" -> {
                            System.out.println("-> Cancelar reserva");

                            System.out.println("Qual o número da reserva? ");
                            int numReserva3 = sc.nextInt();
                            System.out.println("\nDeseja realmente cancelar a sua reserva? (Y / N)");
                            char ch2 = sc.next().charAt(0);
                            if (ch2 == 'y') {
                                System.out.println("O seu valor foi estornado!");
                                try {
                                    vooInterface.cancelarReserva(numReserva3);
                                } catch (ConcurrentModificationException ignored) {
                                }
                            }
                        }
                        case "5" -> {
                            System.out.println("-> Listar voo");

                            String pass = "12345";

                            System.out.println("Informe a senha: ");
                            String senha = sc.next();

                            if (Objects.equals(senha, pass)) {
                                System.out.println("Origem");
                                String origem = sc.next();
                                System.out.println("destino");
                                String destino = sc.next();
                                vooInterface.listarVoo(origem.toUpperCase(), destino.toUpperCase());
                                /*vooInterface.listarVoo(origem, destino);*/
                            } else System.out.println("Senha inválida");
                        }
                        default -> System.out.println("Opção invalida. As opções são de 1 à 5");
                    }
                }
            }
        }
    }
}
