package ProjetosJava;

import ProjetosJava.contratos.Autenticador;
import ProjetosJava.contratos.Notificador;
import ProjetosJava.contratos.OperacaoBancaria;
import ProjetosJava.controladores.ProcessadorTransacaoService;
import ProjetosJava.controladores.SessaoTerminalService;
import ProjetosJava.implementacao.AutenticadorSenhaNumerica;
import ProjetosJava.implementacao.NotificadorEmail;
import ProjetosJava.implementacao.NotificadorSMS;
import ProjetosJava.implementacao.OperacaoSaque;
import ProjetosJava.implementacao.OperacaoTransferencia;
import ProjetosJava.modelos.Cartao;
import ProjetosJava.modelos.Conta;
import ProjetosJava.modelos.TipoTransacao;
import ProjetosJava.modelos.Titular;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("SISTEMA DE TERMINAL BANCARIO / ATM");
        System.out.println("==================================================\n");

        Titular titular1 = new Titular("12345678901", "Alaertes Junior", "alaertes@email.com", "11999990001");
        Conta conta1 = new Conta("1001-1", "0001", 1500.0, titular1);
        Cartao cartao1 = new Cartao("4002-8922", "1234", conta1);

        Titular titular2 = new Titular("98765432100", "Caio Azevedo", "caio@email.com", "11999990002");
        Conta conta2 = new Conta("2002-2", "0001", 300.0, titular2);

        System.out.println("--- CENARIO 1: Saque no Terminal com Notificacao por SMS ---");
        Autenticador autenticador = new AutenticadorSenhaNumerica();
        SessaoTerminalService sessaoTerminal = new SessaoTerminalService(autenticador);

        boolean autenticado = sessaoTerminal.iniciarSessao(cartao1, "1234");
        System.out.println("Autenticacao do cartao: " + (autenticado ? "Sucesso" : "Falha"));

        if (sessaoTerminal.estaAtiva()) {
            Conta contaAtiva = sessaoTerminal.obterContaAutenticada();
            System.out.printf("Saldo inicial: R$ %.2f\n", contaAtiva.getSaldoAtual());

            Notificador notificadorSms = new NotificadorSMS();
            ProcessadorTransacaoService processadorSms = new ProcessadorTransacaoService(notificadorSms);

            OperacaoBancaria saque = new OperacaoSaque();
            processadorSms.processar(saque, contaAtiva, 200.0, TipoTransacao.SAQUE);

            System.out.printf("Saldo final da conta: R$ %.2f\n", contaAtiva.getSaldoAtual());
            sessaoTerminal.encerrarSessao();
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("--- CENARIO 2: Transferencia entre Contas com Notificacao por E-mail ---");
        System.out.printf("Saldo Origem (%s): R$ %.2f\n", conta1.getTitular().getNome(), conta1.getSaldoAtual());
        System.out.printf("Saldo Destino (%s): R$ %.2f\n", conta2.getTitular().getNome(), conta2.getSaldoAtual());

        Notificador notificadorEmail = new NotificadorEmail();
        ProcessadorTransacaoService processadorEmail = new ProcessadorTransacaoService(notificadorEmail);

        OperacaoBancaria transferencia = new OperacaoTransferencia(conta2);
        processadorEmail.processar(transferencia, conta1, 400.0, TipoTransacao.TRANSFERENCIA);

        System.out.printf("Saldo Final Origem (%s): R$ %.2f\n", conta1.getTitular().getNome(), conta1.getSaldoAtual());
        System.out.printf("Saldo Final Destino (%s): R$ %.2f\n", conta2.getTitular().getNome(), conta2.getSaldoAtual());
        System.out.println("\n==================================================");
    }
}