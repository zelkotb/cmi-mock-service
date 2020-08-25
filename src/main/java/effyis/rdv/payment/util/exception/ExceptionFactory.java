package effyis.rdv.payment.util.exception;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public class ExceptionFactory {

	public Exception getException(String type, String returnCode, String message) {
		if (type.equals("billers")) {
			return new BillersException(returnCode, message);
		} else if (type.equals("debts")) {
			return new DebtsException(returnCode, message);
		} else {
			return null;
		}
	}

}
