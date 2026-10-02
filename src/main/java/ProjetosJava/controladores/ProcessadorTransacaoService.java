package ProjetosJava.controladores;

import ProjetosJava.contratos.Conta;
import ProjetosJava.contratos.Notificador;
import ProjetosJava.contratos.OperacaoBancaria;
import ProjetosJava.modelos.StatusTransacao;
import ProjetosJava.modelos.TipoTransacao;
import ProjetosJava.modelos.Transacao;

public class ProcessadorTransacaoService {

	private final Notificador notificador;

	public ProcessadorTransacaoService(Notificador notificador) {
		if (notificador == null) {
			throw new IllegalArgumentException("O notificador e obrigatorio.");
		}
		this.notificador = notificador;
	}

	public Transacao processar(OperacaoBancaria operacao, Conta conta,
							   double valor, TipoTransacao tipoTransacao) {
		if (operacao == null || conta == null || tipoTransacao == null) {
			throw new IllegalArgumentException("Operacao, conta e tipo da transacao sao obrigatorios.");
		}

		StatusTransacao status;
		try {
			operacao.executar(conta, valor);
			status = StatusTransacao.SUCESSO;
		} catch (RuntimeException exception) {
			status = StatusTransacao.FALHA;
		}

		Transacao transacao = new Transacao(tipoTransacao, valor, status);
		notificador.notificar(conta.getTitular(), transacao.obterResumoFormatado()
				+ " - " + status);
		return transacao;
	}
}
