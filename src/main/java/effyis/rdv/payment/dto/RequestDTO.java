package effyis.rdv.payment.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDTO {

	@NotBlank(message = "typeCanal is missing")
	private String typeCanal;
	@NotBlank(message = "aquereurID is missing")
	private String aquereurID;
	@NotBlank(message = "modeID is missing")
	private String modeID;
	@NotBlank(message = "canalID is missing")
	private String canalID;
	@NotBlank(message = "dateServeur is missing")
	private String dateServeur;
	private String refTxSysPmt;
	@JsonProperty("MAC")
	@NotBlank(message = "MAC")
	private String MAC;
	private String creancierID;
	private String creanceID;

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

	public String getMAC() {
		return this.MAC;
	}

	public void setMAC(String mAC) {
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

}