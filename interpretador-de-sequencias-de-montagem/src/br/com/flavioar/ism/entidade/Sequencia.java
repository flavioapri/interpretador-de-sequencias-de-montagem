package br.com.flavioar.ism.entidade;

/**
 * @author Flávio Aparecido Ribeiro
 * 
 */
public class Sequencia {

	private String numero;
	private String tipoDeVeiculo;
	private String variante;
	private String tipoDeCabina;
	private String material;
	private String revestimentoTraseiro;
	private String revestimentoLateral;
	private String codes;
	private String codesRelevantes;
	private String chicote;
	private String pais;	

	public Sequencia() {
		this.numero = "";
		this.tipoDeVeiculo = "";
		this.variante = "";
		this.tipoDeCabina = "";
		this.material = "";
		this.revestimentoTraseiro = "";
		this.revestimentoLateral = "";
		this.codes = "";
		this.codesRelevantes = "";
		this.chicote = "";
		this.pais = "";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String string) {
		this.numero = string;
	}

	public String getTipoDeVeiculo() {
		return tipoDeVeiculo;
	}

	public void setTipoDeVeiculo(String tipoDeCarro) {
		this.tipoDeVeiculo = tipoDeCarro;
	}

	public String getVariante() {
		return variante;
	}

	public void setVariante(String variante) {
		this.variante = variante;
	}

	public String getTipoDeCabina() {
		return tipoDeCabina;
	}

	public void setTipoDeCabina(String tipoDeCabina) {
		this.tipoDeCabina = tipoDeCabina;
	}

	public String getRevestimentoTraseiro() {
		return revestimentoTraseiro;
	}

	public void setRevestimentoTraseiro(String revestimentoTraseiro) {
		this.revestimentoTraseiro = revestimentoTraseiro;
	}

	public String getRevestimentoLateral() {
		return revestimentoLateral;
	}

	public void setRevestimentoLateral(String revestimentoLateral) {
		this.revestimentoLateral = revestimentoLateral;
	}

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

	public String getChicote() {
		return chicote;
	}

	public void setChicote(String chicote) {
		this.chicote = chicote;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodesRelevantes() {
		return codesRelevantes;
	}

	public void setCodesRelevantes(String codesRelevantes) {
		this.codesRelevantes = codesRelevantes;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Sequencia: " + numero + "| Tipo de veículo: " + tipoDeVeiculo + "| Variante: " + variante
				+ "| Tipo de cabina: " + tipoDeCabina + "| Material: " + material + "| Revestimento traseiro: "
				+ revestimentoTraseiro + "| Revestimento Lateral: " + revestimentoLateral + "| Codes: " + codes
				+ "| Chicote: " + chicote + "| País: " + pais;
	}

	public String stringDados() {
		return this.tipoDeVeiculo + " " + this.tipoDeCabina + " " + this.material + " " + this.codes;
	}

}
