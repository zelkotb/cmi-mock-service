package effyis.rdv.payment.dto;

/**
*
* @author EL KOTB ZAKARIA
*
*/
import java.util.List;

import effyis.rdv.payment.entity.FormField;

public class FormFieldsResponseDTO extends BaseDTO {

	private int nbreParams;
	private List<FormField> creancierParams;
	private String refTxFatourati;

	public FormFieldsResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNbreParams() {
		return this.nbreParams;
	}

	public void setNbreParams(int nbreParams) {
		this.nbreParams = nbreParams;
	}

	public List<FormField> getCreancierParams() {
		return this.creancierParams;
	}

	public void setCreancierParams(List<FormField> creancierParams) {
		this.creancierParams = creancierParams;
	}

	public String getRefTxFatourati() {
		return this.refTxFatourati;
	}

	public void setRefTxFatourati(String refTxFatourati) {
		this.refTxFatourati = refTxFatourati;
	}

}
