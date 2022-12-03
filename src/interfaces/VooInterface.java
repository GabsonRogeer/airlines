package interfaces;

import entities.Cliente;
import entities.Reserva;
import entities.Voo;

public interface VooInterface {

    public void adicionaVoo(Voo voo);

    public double calculaValorPassagem(String origem, String destino);

    public void listarVoo(String origem, String destino);

    public void alterarAssento(int reserva, int assento);

    public void alterarTitularidade(int reserva, Cliente cliente);

    public void cancelarReserva(int numReserva, Reserva reserva);
}
