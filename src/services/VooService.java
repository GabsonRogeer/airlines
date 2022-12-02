package services;

import entities.Cliente;
import entities.Voo;

import java.util.ArrayList;
import java.util.List;

public class VooService {

    public final Voo voo = new Voo();

    static List<Voo> vooList = new ArrayList<>();

    public VooService() {
    }

    public void adicionaVoo(Voo voo){
        vooList.add(voo);
        System.out.println("voo adicionado com sucesso!");
    }

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

    public void listarVoo(String origem, String destino) {
        for (Voo voo : vooList) {
            if (voo.getOrigem().equals(origem) && voo.getDestino().equals(destino)) {
                System.out.println(voo);
            }
        }
    }

    public void alteraAssento(int reserva, int assento){
        for (Voo voo: vooList){
            if (voo.getReserva().getNumReserva() == reserva){
                voo.getReserva().setAssento(assento);
            }
        }
        //System.out.println(voo);
    }

    public void alteraTitularidade(int reserva, Cliente cliente){
        for (Voo voo: vooList){
            if (voo.getReserva().getNumReserva() == reserva){
                voo.getReserva().setCliente(cliente);
            }
        }
    }


}
