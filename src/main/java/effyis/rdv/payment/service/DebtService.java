package effyis.rdv.payment.service;

import effyis.rdv.payment.dto.DebtsResponseDTO;
import effyis.rdv.payment.dto.FormFieldsResponseDTO;

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
}
