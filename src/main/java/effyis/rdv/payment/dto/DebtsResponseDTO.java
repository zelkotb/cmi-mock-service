package effyis.rdv.payment.dto;

import java.util.List;

import effyis.rdv.payment.entity.Debt;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public class DebtsResponseDTO {

	private String dateServeur;
	private String codeRetour;
	private String msg;
	private int nbreCreance;
	private List<Debt> listeCreance;
	private String MAC;

	public String getDateServeur() {
		return this.dateServeur;
	}

	public void setDateServeur(String dateServeur) {
		this.dateServeur = dateServeur;
	}

	public String getCodeRetour() {
		return this.codeRetour;
	}

	public void setCodeRetour(String codeRetour) {
		this.codeRetour = codeRetour;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getNbreCreance() {
		return this.nbreCreance;
	}

	public void setNbreCreance(int nbreCreance) {
		this.nbreCreance = nbreCreance;
	}

	public String getMAC() {
		return this.MAC;
	}

	public void setMAC(String mAC) {
		this.MAC = mAC;
	}

	public DebtsResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Debt> getListeCreance() {
		return this.listeCreance;
	}

	public void setListeCreance(List<Debt> listeCreance) {
		this.listeCreance = listeCreance;
	}

}
