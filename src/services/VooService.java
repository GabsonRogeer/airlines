package services;

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

    public void calculaPassageiros(String origem, String destino){
        int count = 0;
        for (Voo voo : vooList){
            if (voo.getOrigem().equals(origem) && voo.getDestino().equals(destino)){
                //System.out.println(voo.getReserva().getAssento());
                count++;
            }
        }
        int valor = 1000 + (5 * count);
        System.out.println(valor);
    }

    public void listarVoo(String origem, String destino) {
        for (Voo voo : vooList) {
            if (voo.getOrigem().equals(origem) && voo.getDestino().equals(destino)) {
                System.out.println(voo);
            }
        }
    }

}
