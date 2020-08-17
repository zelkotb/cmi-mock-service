package effyis.rdv.payment.dto;

import java.util.List;

import effyis.rdv.payment.entity.Biller;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public class BillersResponseDTO {

	private String dateServeur;
	private String codeRetour;
	private String msg;
	private int nbreCreancier;
	private List<Biller> listeCreanciers;
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

	public int getNbreCreancier() {
		return this.nbreCreancier;
	}

	public void setNbreCreancier(int nbreCreancier) {
		this.nbreCreancier = nbreCreancier;
	}

	public List<Biller> getListeCreanciers() {
		return this.listeCreanciers;
	}

	public void setListeCreanciers(List<Biller> listeCreanciers) {
		this.listeCreanciers = listeCreanciers;
	}

	public String getMAC() {
		return this.MAC;
	}

	public void setMAC(String mAC) {
		this.MAC = mAC;
	}

	public BillersResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
