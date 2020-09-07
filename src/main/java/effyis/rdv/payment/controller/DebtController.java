package effyis.rdv.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import effyis.rdv.payment.dto.DebtsResponseDTO;
import effyis.rdv.payment.dto.FormFieldsResponseDTO;
import effyis.rdv.payment.dto.RequestDTO;
import effyis.rdv.payment.service.DebtService;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@RestController
@RequestMapping("/EFFYIS/api/cmi/creances")
public class DebtController {

	@Autowired
	private DebtService debtService;

	@PostMapping
	public DebtsResponseDTO getDebts(@RequestBody RequestDTO dto) throws Exception {
		return this.debtService.getDebts(dto.getTypeCanal(), dto.getAquereurID(), dto.getModeID(), dto.getCanalID(),
				dto.getCreancierID(), dto.getDateServeur(), dto.getRefTxSysPmt(), dto.getMAC());
	}

	@PostMapping("/form")
	public FormFieldsResponseDTO getFormFields(@RequestBody RequestDTO dto) throws Exception {
		return this.debtService.getFormFields(dto.getTypeCanal(), dto.getAquereurID(), dto.getModeID(),
				dto.getCanalID(), dto.getCreancierID(), dto.getCreanceID(), dto.getDateServeur(), dto.getRefTxSysPmt(),
				dto.getMAC());
	}
}
