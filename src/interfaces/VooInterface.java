package interfaces;

import entities.Cliente;
import entities.Voo;

public interface VooInterface {

    void adicionaVoo(Voo voo);

    double calculaValorPassagem(String origem, String destino);

    void listarVoo(String origem, String destino);

    void alterarAssento(int reserva, int assento);

    void alterarTitularidade(int reserva, Cliente cliente);

    void cancelarReserva(int numReserva);
}
