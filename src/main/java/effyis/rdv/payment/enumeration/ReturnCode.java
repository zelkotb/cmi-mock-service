package effyis.rdv.payment.enumeration;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public enum ReturnCode {

	C000("000", "ACCEPT", "ACCEPT"), C100("100", "ANNULE", "SIGNATURE INVALID"),
	C101("101", "ANNULE", "SYSTEME DE PAIEMENT INEXISTANT"),
	C102("102", "ANNULE", "TYPE CREANCE INACTIVE POUR LE SYSTEME DE PAIEMENT CHOISI"),
	C103("103", "ANNULE", "TYPE CREANCE INACTIVE POUR L FOURNISSEUR CHOISI"),
	C104("104", "ANNULE", "CREANCIER INEXISTANT"), C105("105", "ANNULE", "CREANCE INEXISTANTE"),
	C111("111", "ANNULE", "AUCUN FORMULAIRE LIEE A LA CREANCE"), C112("112", "ANNULE", "CATEGORY INEXISTANT"),
	C113("113", "ANNULE", "CANAL INEXISTANT"), C902("902", "ANNULE", "INVALIDE TRANSACTION"),
	C908("908", "ANNULE", "ERREUR SYSTEME FATOURATI");

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
