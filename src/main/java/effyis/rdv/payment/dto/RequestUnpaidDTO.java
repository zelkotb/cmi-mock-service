package effyis.rdv.payment.dto;

import java.util.Arrays;
import java.util.List;

public class RequestUnpaidDTO extends RequestDTO {

	private String refTxFatourati;
	private List<FormFieldDTO> creancierVals;
	private String outlet;
	private String location;

	public RequestUnpaidDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRefTxFatourati() {
		return this.refTxFatourati;
	}

	public void setRefTxFatourati(String refTxFatourati) {
		this.refTxFatourati = refTxFatourati;
	}

	public List<FormFieldDTO> getCreancierVals() {
		return this.creancierVals;
	}

	public void setCreancierVals(List<FormFieldDTO> creancierVals) {
		this.creancierVals = creancierVals;
	}

	public String getOutlet() {
		return this.outlet;
	}

	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("{ typeCanal: ");
		str.append(this.typeCanal).append(", aquereurID: ").append(this.aquereurID).append(", modeID: ")
				.append(this.modeID).append(", canalID: ").append(this.canalID).append(", outlet: ").append(this.outlet)
				.append(", location: ").append(this.location).append(", dateServeur: ").append(this.dateServeur)
				.append(", refTxSysPmt: ").append(this.refTxSysPmt).append(", refTxFatourati: ")
				.append(this.refTxFatourati).append(", MAC: ").append(Arrays.toString(this.MAC))
				.append(", creancierID: ").append(this.creancierID).append(", creanceID: ").append(this.creanceID)
				.append(", creancierVals: ").append(this.creancierVals.toString()).append(" }");
		return str.toString();
	}

}
