package br.com.flavioar.ism.entidade;

public enum Codes {
	
	DD5(false, "ALTO"),
	FP6(true, "TECIDO"),
	FF8(false, "CORTINA"),
	EV2(true, "RADIO PX"),
	EX3(true, "ARMAÇÃO FLEETBOARD"),
	YM1(true, "APARELHO FLEETBOARD"),
	F20(false, "ESTENDIDA"),
	F35(false, "JANELA"),
	F04(false, "LEITO"),
	S28(false, "CENTRAL"),
	DS7(true, "PORTINHOLA"),
	SM7(true, "BAGAGEIRO"),
	SM2(true, "BELICHE"),
	EP2(true, "KIT MULTIMÍDIA"),
	EP3(true, "KIT MULTIMÍDIA"),
	J16(true, "TACÓGRAFO SEMANAL"),
	J14(true, "TACÓGRAFO DIÁRIO"),
	JU0(true, "TACÓGRAFO DIGITAL"),
	HK1(true, "CLIMATIZADOR");
	
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
