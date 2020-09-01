package effyis.rdv.payment.util.exception;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public class FormFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String returnCode;
	private final String message;

	public FormFieldException(String returnCode, String message) {
		super();
		this.returnCode = returnCode;
		this.message = message;
	}

	public String getReturnCode() {
		return this.returnCode;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
