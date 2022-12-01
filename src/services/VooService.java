package services;

import entities.Voo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VooService {

    public final Voo voo = new Voo();

    static List<Voo> vooList = new ArrayList<>();

    public VooService() {
    }

    public static int calculaPassageiros(String origem, String destino){
        int count = 0;
        for (Voo voo : vooList){
            if (voo.getOrigem().equals(origem) && voo.getDestino().equals(destino)){
                count = Arrays.stream(voo.getReserva().getNumReserva()).toArray().length;
            }
        }
        return count;
    }

}
