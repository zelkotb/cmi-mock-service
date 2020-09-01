package effyis.rdv.payment.dto;

import java.util.List;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public class BillersResponseDTO extends BaseDTO{


	private int nbreCreancier;
	private List<BillerDTO> listeCreanciers;


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


	public BillersResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
