package effyis.rdv.payment.dto;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public class BaseDTO {

	private String dateServeur;
	private String codeRetour;
	private String msg;
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

	public String getMAC() {
		return this.MAC;
	}

	public void setMAC(String mAC) {
		this.MAC = mAC;
	}

}
