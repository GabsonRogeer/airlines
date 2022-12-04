package entities;

import java.util.ArrayList;
import java.util.List;


public class Voo {

    private String origem;
    private String destino;
    private Reserva reserva;

    private double valor;
    private final List<Reserva> reservaList = new ArrayList<>();

    public Voo() {
    }

    public Voo(String origem, String destino, Reserva reserva, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.reserva = reserva;
        this.valor = valor;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void addReserva(Reserva reserva){
        reservaList.add(reserva);
    }

    @Override
    public String toString() {
        return "Voo :" +
                " Origem = '" + origem + '\'' +
                ", Destino = '" + destino + '\'' +
                reservaList +
                ", Valor: R$ " + String.format("%.2f", valor) +
                '\n';

    }
}
