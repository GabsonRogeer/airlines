package services;

import entities.Cliente;
import entities.Voo;
import interfaces.VooInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VooService implements VooInterface {

    static List<Voo> vooList = new ArrayList<>();

    public VooService() {
    }

    @Override
    public void adicionaVoo(Voo voo){
        vooList.add(voo);
    }

    @Override
    public double calculaValorPassagem(String origem, String destino) {
        int count = 1;
            for (Voo voo : vooList) {
                if (voo.getOrigem().equals(origem) && voo.getDestino().equals(destino)) {
                    if (voo.getReserva().getAssento() > 6) {
                        count++;
                    }
                }
            }
        return 100 + (5 * Math.log10(count));
    }

    @Override
    public void listarVoo(String origem, String destino) {
        double valorTotal = 0;
        vooList.sort(Comparator.comparing(voo -> voo.getReserva().getAssento()));
        for (Voo voo : vooList) {
            if (voo.getOrigem().equals(origem) && voo.getDestino().equals(destino)) {
                valorTotal += voo.getValor();
                System.out.println(voo);
            }
        }
        System.out.printf("O valor total é de: R$ %.2f\"%n", valorTotal);
    }

    @Override
    public void alterarAssento(int reserva, int assento) {
        for (Voo voo : vooList) {
            if (voo.getReserva().getNumReserva() == reserva){
                if (assento <= 6) {
                    voo.setValor(voo.getValor() + 50.00);
                    voo.getReserva().setAssento(assento);
                }
                else {
                    voo.getReserva().setAssento(assento);
                }
            }
        }
    }

    @Override
    public void alterarTitularidade(int reserva, Cliente cliente) {
        for (Voo voo : vooList) {
            if (voo.getReserva().getNumReserva() == reserva) {
                voo.getReserva().setCliente(cliente);
            }
        }
    }

    @Override
    public void cancelarReserva(int numReserva) {
        vooList.removeIf(voo -> voo.getReserva().getNumReserva() == numReserva);
    }
}
