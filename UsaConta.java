package br.com.fiap.main;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import br.com.fiap.bean.ContaBancaria;
import br.com.fiap.bean.ContaEspecial;
import br.com.fiap.bean.ContaPoupanca;

public class UsaConta {
	
	public static void main(String[] args) {
		String aux, escolha = "sim", cliente;
		int opcao, opcao2, numConta, diaRend;
		float saldo, saque, deposito, limite;
		
		while(escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Seja bem-vindo! \nQual o tipo de conta possui?"
						+ "\n(1) Normal \n(2) Poupança \n (3) Especial");
				opcao = Integer.parseInt(aux);
				
				cliente = JOptionPane.showInputDialog("Digite o seu nome: ");
				numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da sua conta: "));
				saldo = Float.parseFloat(JOptionPane.showInputDialog("Digite o saldo da sua conta: "));
				
				switch(opcao) {
				case 1: 
					ContaBancaria cb = new ContaBancaria();
					cb.setCliente(cliente);
					cb.setNumConta(numConta);
					cb.setSaldo(saldo);
					aux = JOptionPane.showInputDialog("O que você deseja fazer? "
							+ "\n(1)Saque \n(2)Depósito");
					opcao2 = Integer.parseInt(aux);
					switch(opcao2) {
					case 1:
						saque = Float.parseFloat(JOptionPane.showInputDialog("Valor do saque: "));
						JOptionPane.showMessageDialog(null, "Saldo final: " + cb.sacar(saque));
						break;
					case 2: 
						deposito = Float.parseFloat(JOptionPane.showInputDialog("Valor do depósito: "));
						JOptionPane.showMessageDialog(null, "Saldo final: " + cb.depositar(deposito));
						break;
					default: 
						throw new Exception("Escolha incorreta!");
					}
					JOptionPane.showMessageDialog(null, "Exibindo informações da conta"
							+ "\nNome: " + cb.getCliente()
							+ "\nNúmero da conta: " + cb.getNumConta()
							+ "\nSaldo atual: " + cb.getSaldo());
					break;
				case 2: 
					diaRend = Integer.parseInt(JOptionPane.showInputDialog("Dia de rendimento: "));
					ContaPoupanca cp = new ContaPoupanca();
					cp.setCliente(cliente);
					cp.setNumConta(numConta);
					cp.setSaldo(saldo);
					cp.setDiaDeRendimento(diaRend);
					aux = JOptionPane.showInputDialog("O que você deseja fazer? "
							+ "\n(1)Saque \n(2)Depósito");
					opcao2 = Integer.parseInt(aux);
					switch(opcao2) {
					case 1:
						saque = Float.parseFloat(JOptionPane.showInputDialog("Valor do saque: "));
						JOptionPane.showMessageDialog(null, "Saldo final: " + cp.sacar(saque));
						break;
					case 2: 
						deposito = Float.parseFloat(JOptionPane.showInputDialog("Valor do depósito: "));
						JOptionPane.showMessageDialog(null, "Saldo final: " + cp.depositar(deposito));
						break;
					default: 
						throw new Exception("Escolha incorreta!");
					}
					int dia = LocalDate.now().getDayOfMonth();
					if ( dia >= cp.getDiaDeRendimento() ) {
						float rend = Float.parseFloat(JOptionPane.showInputDialog("Qual a taxa de rendimento? "));
						cp.novoSaldo(rend);
					}
					JOptionPane.showMessageDialog(null, "Exibindo informações da conta"
							+ "\nNome: " + cp.getCliente()
							+ "\nNúmero da conta: " + cp.getNumConta()
							+ "\nSaldo atual: " + cp.getSaldo());
					break;
				case 3: 
					limite = Float.parseFloat(JOptionPane.showInputDialog("Limite: "));
					ContaEspecial ce = new ContaEspecial();
					ce.setCliente(cliente);
					ce.setNumConta(numConta);
					ce.setSaldo(saldo);
					ce.setLimite(limite);
					aux = JOptionPane.showInputDialog("O que você deseja fazer? "
							+ "\n(1)Saque \n(2)Depósito");
					opcao2 = Integer.parseInt(aux);
					switch(opcao2) {
					case 1:
						saque = Float.parseFloat(JOptionPane.showInputDialog("Valor do saque: "));
						JOptionPane.showMessageDialog(null, "Saldo final: " + ce.sacar(saque));
						break;
					case 2: 
						deposito = Float.parseFloat(JOptionPane.showInputDialog("Valor do depósito: "));
						JOptionPane.showMessageDialog(null, "Saldo final: " + ce.depositar(deposito));
						break;
					default: 
						throw new Exception("Escolha incorreta!");
					}
					
					JOptionPane.showMessageDialog(null, "Exibindo informações da conta"
							+ "\nNome: " + ce.getCliente()
							+ "\nNúmero da conta: " + ce.getNumConta()
							+ "\nSaldo atual: " + ce.getSaldo());
					break;
					default: 
						throw new Exception("Escolha incorreta!");
				}
				escolha = JOptionPane.showInputDialog("Deseja continuar?");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		JOptionPane.showMessageDialog(null, "Fim do programa, obrigado!");
	}

}
