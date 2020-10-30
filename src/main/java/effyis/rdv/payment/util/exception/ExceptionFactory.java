package effyis.rdv.payment.util.exception;

import effyis.rdv.payment.util.Constants;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public class ExceptionFactory {

	public Exception getException(String type, String returnCode, String message) throws Exception {
		switch (type) {
		case Constants.FACTORY_BILLERS:
			return new BillersException(returnCode, message);
		case Constants.FACTORY_DEBTS:
			return new DebtsException(returnCode, message);
		case Constants.FACTORY_FORMFIELDS:
			return new FormFieldException(returnCode, message);
		case Constants.FACTORY_UNPAIDS:
			return new FormFieldException(returnCode, message);
		default:
			throw new Exception();
		}
	}

}
