package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class ContaBancaria {
	
	private String cliente;
	private int numConta;
	private float saldo;
	
	public ContaBancaria() {}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public float sacar(float valor) {
		float novoSaldo = saldo;
			if (valor <= saldo) {
				novoSaldo = saldo - valor;
			} else {
				JOptionPane.showMessageDialog(null, "Valor superioro ao seu saldo atual");
			}
			saldo = novoSaldo;
			return saldo;
	}
	
	public float depositar (float valor) {
		return saldo += valor;
	}

}
