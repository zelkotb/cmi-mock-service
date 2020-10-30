package effyis.rdv.payment.service;

import effyis.rdv.payment.dto.DebtsResponseDTO;
import effyis.rdv.payment.dto.FormFieldsResponseDTO;
import effyis.rdv.payment.entity.Debt;
import effyis.rdv.payment.enumeration.Canal;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public interface DebtService {

	DebtsResponseDTO getDebts(String typeCanal, String aquereurID, String modeID, String canalID, String creancierID,
			String dateServeur, String refTxSysPmt, byte[] MAC) throws Exception;

	FormFieldsResponseDTO getFormFields(String typeCanal, String aquereurID, String modeID, String canalID,
			String creancierID, String creanceID, String dateServeur, String refTxSysPmt, byte[] MAC) throws Exception;

	Canal getCanal(String typeCanal, String type) throws Exception;

	void isBillerExiste(String creancierID, String type) throws Exception;

	Debt isDebtExisteAndActive(String creancierID, String creanceID, String typeCanal);
}
