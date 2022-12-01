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

        Scanner sc = new Scanner(System.in);
        VooService service = new VooService();
        List<Voo> voos = new ArrayList<>();

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

        System.out.println(v1);

    }
}
