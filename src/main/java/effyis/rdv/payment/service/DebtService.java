package effyis.rdv.payment.service;

import effyis.rdv.payment.dto.DebtsResponseDTO;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public interface DebtService {

	DebtsResponseDTO getDebts(String typeCanal, String aquereurID, String modeID, String canalID, String creancierID,
			String dateServeur, String categorieCreance, String refTxSysPmt, String MAC) throws Exception;
}
