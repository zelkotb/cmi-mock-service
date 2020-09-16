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
	private byte[] MAC;

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

	public byte[] getMAC() {
		return this.MAC;
	}

	public void setMAC(byte[] mAC) {
		this.MAC = mAC;
	}

}
