package effyis.rdv.payment.dto;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDTO {

	@NotBlank(message = "typeCanal is missing")
	protected String typeCanal;
	@NotBlank(message = "aquereurID is missing")
	protected String aquereurID;
	@NotBlank(message = "modeID is missing")
	protected String modeID;
	@NotBlank(message = "canalID is missing")
	protected String canalID;
	@NotBlank(message = "dateServeur is missing")
	protected String dateServeur;
	protected String refTxSysPmt;
	@JsonProperty("MAC")
	protected byte[] MAC;
	protected String creancierID;
	protected String creanceID;

	public String getTypeCanal() {
		return this.typeCanal;
	}

	public void setTypeCanal(String typeCanal) {
		this.typeCanal = typeCanal;
	}

	public String getAquereurID() {
		return this.aquereurID;
	}

	public void setAquereurID(String aquereurID) {
		this.aquereurID = aquereurID;
	}

	public String getModeID() {
		return this.modeID;
	}

	public void setModeID(String modeID) {
		this.modeID = modeID;
	}

	public String getCanalID() {
		return this.canalID;
	}

	public void setCanalID(String canalID) {
		this.canalID = canalID;
	}

	public String getDateServeur() {
		return this.dateServeur;
	}

	public void setDateServeur(String dateServeur) {
		this.dateServeur = dateServeur;
	}

	public String getRefTxSysPmt() {
		return this.refTxSysPmt;
	}

	public void setRefTxSysPmt(String refTxSysPmt) {
		this.refTxSysPmt = refTxSysPmt;
	}

	public byte[] getMAC() {
		return this.MAC;
	}

	public void setMAC(byte[] mAC) {
		this.MAC = mAC;
	}

	public String getCreancierID() {
		return this.creancierID;
	}

	public void setCreancierID(String creancierID) {
		this.creancierID = creancierID;
	}

	public String getCreanceID() {
		return this.creanceID;
	}

	public void setCreanceID(String creanceID) {
		this.creanceID = creanceID;
	}

	public RequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("{ typeCanal: ");
		str.append(this.typeCanal).append(", aquereurID: ").append(this.aquereurID).append(", modeID: ")
				.append(this.modeID).append(", canalID: ").append(this.canalID).append(", dateServeur: ")
				.append(this.dateServeur).append(", refTxSysPmt: ").append(this.refTxSysPmt).append(", MAC: ")
				.append(Arrays.toString(this.MAC)).append(", creancierID: ").append(this.creancierID)
				.append(", creanceID: ").append(this.creanceID).append(" }");

		return str.toString();
	}

}
