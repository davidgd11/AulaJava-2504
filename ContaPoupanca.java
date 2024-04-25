package br.com.fiap.bean;

public class ContaPoupanca extends ContaBancaria{
	
	private int diaDeRendimento;
	
	public ContaPoupanca() {}
	
	public int getDiaDeRendimento() {
		return diaDeRendimento;
	}

	public void setDiaDeRendimento(int diaDeRendimento) {
		this.diaDeRendimento = diaDeRendimento;
	}
	
	public void novoSaldo(float rendimento) {
		float novoSaldo = super.getSaldo() * (1 + rendimento / 100);
		super.setSaldo(novoSaldo);
	}
}
