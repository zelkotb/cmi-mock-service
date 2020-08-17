package effyis.rdv.payment.enumeration;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public enum ReturnCode {

	C000("000", "ACCEPT", "ACCEPT"), C100("100", "ANNULE", "SIGNATURE INVALID"),
	C101("101", "ANNULE", "SYSTEME DE PAIEMENT INEXISTANT"), C104("104", "ANNULE", "CREANCIER INEXISTANT"),
	C112("112", "ANNULE", "CATEGORY INEXISTANT"), C113("113", "ANNULE", "CANAL INEXISTANT");

	private String returnCode;
	private String status;
	private String comment;

	private ReturnCode(String returnCode, String status, String comment) {
		this.returnCode = returnCode;
		this.status = status;
		this.comment = comment;
	}

	public String getReturnCode() {
		return this.returnCode;
	}

	public String getStatus() {
		return this.status;
	}

	public String getComment() {
		return this.comment;
	}

}
