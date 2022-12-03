package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Passagem {

    private Cliente cliente;
    private Long valor;
    private LocalDateTime reserva;
    private int assento;

    private Voo voo;

    private final List<Voo> voos = new ArrayList<>();


    public Passagem() {
    }

    public Passagem(Cliente cliente, Voo voo) {
        Random random = new Random();
        this.cliente = cliente;
        this.voo = voo;
        this.reserva = LocalDateTime.now();
        this.assento = random.nextInt(220) + 1;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public LocalDateTime getReserva() {
        return reserva;
    }

    public void setReserva(LocalDateTime reserva) {
        this.reserva = reserva;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public void adicionaVoo (Voo voo){
        voos.add(voo);
    }

    public void removeVoo (Voo voo){
        voos.remove(voo);
    }

    @Override
    public String toString() {
        return "Passagem{" +
                "cliente=" + cliente +
                ", reserva=" + reserva +
                ", assento=" + assento +
                ", voos=" + voos +
                '}';
    }

}
