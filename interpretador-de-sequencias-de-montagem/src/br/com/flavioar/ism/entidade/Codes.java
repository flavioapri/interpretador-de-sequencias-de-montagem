package br.com.flavioar.ism.entidade;

public enum Codes {
	
	FP6(true, "TECIDO"),
	EP2(true, "KIT MULTIM�DIA"),
	EP3(true, "KIT MULTIM�DIA"),
	EX3(true, "ARMA��O FLEETBOARD"),
	DS7(true, "PORTINHOLA"),	
	S28(false, "CENTRAL"),
	FF8(false, "CORTINA"),
	F04(false, "LEITO"),	
	DD5(false, "ALTO"),	
	YM1(true, "APARELHO FLEETBOARD"),
	F20(false, "ESTENDIDA"),
	F35(false, "JANELA"),	
	SM7(true, "BAGAGEIRO"),
	SM2(true, "BELICHE"),
	J16(true, "TAC�GRAFO SEMANAL"),
	J14(true, "TAC�GRAFO DI�RIO"),
	JU0(true, "TAC�GRAFO DIGITAL"),
	EV2(true, "RADIO PX"),	
	HK1(true, "CLIMATIZADOR"),
	FF4(false, "REDE NA PAREDE TRASEIRA");
	
	private String nomeUsual;
	private boolean relevante;

	private Codes(boolean relevante, String nomeUsual) {
		this.relevante = relevante;
		this.nomeUsual = nomeUsual;		
	}

	public String getNomeUsual() {
		return nomeUsual;
	}
	
	public boolean isRelevante() {
		return relevante;
	}
	
}
