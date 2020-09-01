package effyis.rdv.payment.dto;

import java.util.List;

import effyis.rdv.payment.entity.Debt;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public class DebtsResponseDTO extends BaseDTO{

	private int nbreCreance;
	private List<Debt> listeCreance;

	public DebtsResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNbreCreance() {
		return this.nbreCreance;
	}

	public void setNbreCreance(int nbreCreance) {
		this.nbreCreance = nbreCreance;
	}

	public List<Debt> getListeCreance() {
		return this.listeCreance;
	}

	public void setListeCreance(List<Debt> listeCreance) {
		this.listeCreance = listeCreance;
	}





}
