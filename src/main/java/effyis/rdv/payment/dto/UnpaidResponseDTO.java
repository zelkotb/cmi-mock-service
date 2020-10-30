package effyis.rdv.payment.dto;

import java.util.List;

import effyis.rdv.payment.entity.Unpaid;

public class UnpaidResponseDTO extends BaseDTO {

	private String refTxFatourati;
	private String typeFrais;
	private String valeurFrais;
	private String seuilMinimal;
	private List<String> globalParams;
	private String codeDevise;
	private int nbreCreances;
	private String montantTotalTTC;
	private List<Unpaid> impayesParams;

	public String getRefTxFatourati() {
		return this.refTxFatourati;
	}

	public void setRefTxFatourati(String refTxFatourati) {
		this.refTxFatourati = refTxFatourati;
	}

	public String getTypeFrais() {
		return this.typeFrais;
	}

	public void setTypeFrais(String typeFrais) {
		this.typeFrais = typeFrais;
	}

	public String getValeurFrais() {
		return this.valeurFrais;
	}

	public void setValeurFrais(String valeurFrais) {
		this.valeurFrais = valeurFrais;
	}

	public String getSeuilMinimal() {
		return this.seuilMinimal;
	}

	public void setSeuilMinimal(String seuilMinimal) {
		this.seuilMinimal = seuilMinimal;
	}

	public List<String> getGlobalParams() {
		return this.globalParams;
	}

	public void setGlobalParams(List<String> globalParams) {
		this.globalParams = globalParams;
	}

	public String getCodeDevise() {
		return this.codeDevise;
	}

	public void setCodeDevise(String codeDevise) {
		this.codeDevise = codeDevise;
	}

	public int getNbreCreances() {
		return this.nbreCreances;
	}

	public void setNbreCreances(int nbreCreances) {
		this.nbreCreances = nbreCreances;
	}

	public String getMontantTotalTTC() {
		return this.montantTotalTTC;
	}

	public void setMontantTotalTTC(String montantTotalTTC) {
		this.montantTotalTTC = montantTotalTTC;
	}

	public List<Unpaid> getImpayesParams() {
		return this.impayesParams;
	}

	public void setImpayesParams(List<Unpaid> impayesParams) {
		this.impayesParams = impayesParams;
	}

	public UnpaidResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
