package br.com.fiap.bean;

import javax.swing.JOptionPane;

public class ContaEspecial extends ContaBancaria{

	private float limite;
	
	public ContaEspecial() {}
	
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	public float sacar(float valor) {
		float novoSaldo = super.getSaldo();
			if (valor <= (super.getSaldo() + limite)) {
				novoSaldo = super.getSaldo() - valor;
			} else {
				JOptionPane.showMessageDialog(null, "Valor superior ao seu limite!");
			}
			super.setSaldo(novoSaldo);
			return super.getSaldo();
	}
	
	
}
