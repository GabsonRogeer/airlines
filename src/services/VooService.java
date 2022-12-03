package services;

import entities.Cliente;
import entities.Reserva;
import entities.Voo;
import interfaces.VooInterface;

import java.util.ArrayList;
import java.util.List;

public class VooService implements VooInterface {

    static List<Voo> vooList = new ArrayList<>();

    public VooService() {
    }

    @Override
    public void adicionaVoo(Voo voo){
        vooList.add(voo);
        System.out.println("voo adicionado com sucesso!");
    }

    @Override
    public double calculaValorPassagem(String origem, String destino){
        int count = 0;
        for (Voo voo : vooList){
            if (voo.getOrigem().equals(origem) && voo.getDestino().equals(destino)){
                if (voo.getReserva().getAssento() > 6){
                    count++;
                }
            }
        }
        return 100 + (5 * Math.log10(count));
    }

    @Override
    public void listarVoo(String origem, String destino) {
        for (Voo voo : vooList) {
            if (voo.getOrigem().equals(origem) && voo.getDestino().equals(destino)) {
                System.out.println(voo);
            }
        }
    }

    @Override
    public void alterarAssento(int reserva, int assento) {
        for (Voo voo: vooList){
            if (voo.getReserva().getNumReserva() == reserva){
                voo.getReserva().setAssento(assento);
            }
        }
    }

    @Override
    public void alterarTitularidade(int reserva, Cliente cliente) {
        for (Voo voo: vooList){
            if (voo.getReserva().getNumReserva() == reserva){
                voo.getReserva().setCliente(cliente);
            }
        }
    }

    @Override
    public void cancelarReserva(int numReserva, Reserva reserva) {
        for (Voo voo : vooList){
            if (voo.getReserva().getNumReserva() == numReserva){
                if (voo.getReserva() == reserva){
                    voo.removeReserva(reserva);
                    System.out.println("voo removido com sucesso!");
                }
            }
        }
    }
}
