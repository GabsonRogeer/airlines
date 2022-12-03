package entities;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Voo {

    private String origem;
    private String destino;
    private Reserva reserva;
    private final List<Reserva> reservaList = new ArrayList<>();

    public Voo() {
    }

    public Voo(String origem, String destino, Reserva reserva) {
        this.origem = origem;
        this.destino = destino;
        this.reserva = reserva;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void addReserva(Reserva reserva){
        reservaList.add(reserva);
    }

    public void removeReserva(Reserva reserva){
        reservaList.remove(reserva);
    }


    @Override
    public String toString() {
        return "Voo{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                reservaList +
                '}';
    }
}
