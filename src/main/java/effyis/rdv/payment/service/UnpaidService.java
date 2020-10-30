package effyis.rdv.payment.service;

import java.util.List;

import effyis.rdv.payment.dto.FormFieldDTO;
import effyis.rdv.payment.dto.UnpaidResponseDTO;

public interface UnpaidService {

	UnpaidResponseDTO getUnpaid(String typeCanal, String aquereurID, String modeID, String canalID, String outlet,
			String location, String creancierID, String creanceID, String dateServeur, String refTxSysPmt,
			String refTxFatourati, List<FormFieldDTO> formFields, byte[] MAC) throws Exception;
}
