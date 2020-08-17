package effyis.rdv.payment.service;

import effyis.rdv.payment.dto.BillersResponseDTO;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public interface BillerService {

	BillersResponseDTO getBillers(String typeCanal, String aquereurID, String modeID, String canalID,
			String dateServeur, String categorieCreance, String refTxSysPmt, String MAC) throws Exception;
}
