package entities;

import java.util.Arrays;
import java.util.Random;

public class Reserva {

    private int numReserva;
    private Cliente cliente;
    private int assento;

    public Reserva() {
    }

    public Reserva(Cliente cliente) {
        Random random = new Random();
        this.numReserva = random.nextInt(9999) + 1;
        this.cliente = cliente;
        //todo: O rolê dos 7+
        this.assento = random.nextInt(7, 220) + 1;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

    @Override
    public String toString() {
        return "Número da Reserva = " + numReserva +
                ", Dados do cliente: " + cliente +
                ", Assento =" + assento;
    }
}
