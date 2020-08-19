package effyis.rdv.payment.dto;

import java.util.List;

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
	private List<BillerDTO> listeCreanciers;
	private String MAC;
	private String category;

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

	public List<BillerDTO> getListeCreanciers() {
		return this.listeCreanciers;
	}

	public void setListeCreanciers(List<BillerDTO> listeCreanciers) {
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

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
