package ProjetosJava.controladores;

import ProjetosJava.contratos.Autenticador;
import ProjetosJava.contratos.Conta;
import ProjetosJava.modelos.Cartao;

public class SessaoTerminalService {

	private final Autenticador autenticador;
	private Cartao cartaoAutenticado;

	public SessaoTerminalService(Autenticador autenticador) {
		if (autenticador == null) {
			throw new IllegalArgumentException("O autenticador e obrigatorio.");
		}
		this.autenticador = autenticador;
	}

	public boolean iniciarSessao(Cartao cartao, String credencial) {
		this.cartaoAutenticado = null;
		if (cartao == null) {
			throw new IllegalArgumentException("Cartao nao informado.");
		}
		if (cartao.estaBloqueado() || !cartao.getConta().estaAtiva()) {
			return false;
		}
		if (!autenticador.autenticar(cartao, credencial)) {
			return false;
		}

		this.cartaoAutenticado = cartao;
		return true;
	}

	public boolean estaAtiva() {
		return this.cartaoAutenticado != null;
	}

	public Conta obterContaAutenticada() {
		if (!estaAtiva()) {
			throw new IllegalStateException("Nao ha uma sessao autenticada.");
		}
		return this.cartaoAutenticado.getConta();
	}

	public void encerrarSessao() {
		this.cartaoAutenticado = null;
	}
}
