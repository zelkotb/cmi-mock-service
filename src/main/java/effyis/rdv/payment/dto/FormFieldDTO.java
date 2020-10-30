package effyis.rdv.payment.dto;

public class FormFieldDTO {

	private String nomChamp;
	private String valeurChamp;

	public String getNomChamp() {
		return this.nomChamp;
	}

	public void setNomChamp(String nomChamp) {
		this.nomChamp = nomChamp;
	}

	public String getValeurChamp() {
		return this.valeurChamp;
	}

	public void setValeurChamp(String valeurChamp) {
		this.valeurChamp = valeurChamp;
	}

	public FormFieldDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("{ nomChamp: '");
		str.append(this.nomChamp).append("', valeurChamp: '").append(this.valeurChamp).append("' }");
		return str.toString();
	}

}
