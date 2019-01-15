package br.alura.refatoracao.cap2;

import java.util.List;

public class Trem {

    private List<Vagao> vagoes;
    private int capacidade;

    public boolean podeReservar(int lugaresARevervar) {
	int lugaresDisponiveis = capacidade - lugaresJaReservados();
	return lugaresDisponiveis > lugaresARevervar;
    }

    private int lugaresJaReservados() {
	int lugaresJaReservados = 0;
	for (Vagao vagao : vagoes) {
	    lugaresJaReservados += vagao.reservados();
	}
	return lugaresJaReservados;
    }

}