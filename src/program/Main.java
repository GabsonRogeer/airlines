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

            Cliente cliente = new Cliente("Ingrid", "1234556");
            Reserva reserva = new Reserva(cliente);
            Voo voo = new Voo("FOR", "SSA", reserva);
            voo.addReserva(reserva);
            service.adicionaVoo(voo);

            Cliente cliente2 = new Cliente("Renata", "1234556");
            Reserva reserva2 = new Reserva(cliente2);
            Voo voo2 = new Voo("FOR", "SSA", reserva2);
            voo2.addReserva(reserva2);
            service.adicionaVoo(voo2);

            Cliente cliente3 = new Cliente("Gabson", "1234556");
            Reserva reserva3 = new Reserva(cliente3);
            Voo voo3 = new Voo("FOR", "SSA", reserva3);
            voo3.addReserva(reserva3);
            service.adicionaVoo(voo3);

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
                        System.out.println("Qual a sua origem? ");
                        String origem = sc.next();
                        System.out.println("Qual o seu destino? ");
                        String destino = sc.next();

                        System.out.printf("O Valor da sua passagem é: " +
                                service.calculaValorPassagem(origem, destino));
                        System.out.println("Deseja comprar a passagem? (Y / N)");
                        char ch = sc.next().charAt(0);
                        if (ch == 'y'){
                            String nome, cpf;
                            System.out.println("Digite seu nome: ");
                            nome = sc.next();
                            System.out.println("digite seu cpf: ");
                            cpf = sc.next();
                            Cliente c1 = new Cliente(nome, cpf);
                            Reserva r1 = new Reserva(c1);
                            Voo v1 = new Voo(origem, destino, r1);
                            v1.addReserva(r1);
                            voos.add(v1);
                            service.adicionaVoo(v1);
                            System.out.println(v1);
                        }
                        //service.listarVoo(origem, destino);
                    }
                    case "2" -> {
                        System.out.println("-> Alterar Assento");
                        System.out.println("Qual o número da reserva? ");
                        int numReserva = sc.nextInt();
                        System.out.println("Qual número do assento que você deseja? ");
                        int assento = sc.nextInt();

                        service.alteraAssento(numReserva, assento);
                        System.out.println("Assento alterado com sucesso!");

                    }
                    case "3" -> {
                        System.out.println("-> Altera titularidade");
                        System.out.println("Qual o número da reserva? ");
                        int numReserva = sc.nextInt();

                        System.out.println("Qual o nome do novo titular?");
                        String nome = sc.next();

                        System.out.println("Qual o CPF do novo titular?");
                        String cpf = sc.next();

                        Cliente novoCliente = new Cliente(nome, cpf);

                        service.alteraTitularidade(numReserva, novoCliente);

                        System.out.println("Titularidade alterada com sucesso!");
                    }
                    case "4" -> {
                        System.out.println("Função ainda não implementada");
                    }
                    case "5" -> {
                        System.out.println("-> Listar voo");
                        System.out.println("Origem");
                        String origem = sc.next();

                        System.out.println("destino");
                        String destino = sc.next();

                        service.listarVoo(origem, destino);;
                    }
                    default -> {
                    }
                }
            } while (!sair);
        }
    }
}
