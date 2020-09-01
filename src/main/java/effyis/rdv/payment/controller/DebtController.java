package effyis.rdv.payment.controller;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import effyis.rdv.payment.dto.DebtsResponseDTO;
import effyis.rdv.payment.dto.FormFieldsResponseDTO;
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

	@GetMapping
	public DebtsResponseDTO getDebts(@RequestParam String typeCanal, @RequestParam String aquereurID,
			@RequestParam String modeID, @RequestParam String canalID, @RequestParam String creancierID,
			@RequestParam String dateServeur, @RequestParam(required = false) String refTxSysPmt,
			@RequestParam String MAC) throws Exception {
		String realMAC = URLDecoder.decode(MAC, StandardCharsets.UTF_8);
		return this.debtService.getDebts(typeCanal, aquereurID, modeID, canalID, creancierID, dateServeur, refTxSysPmt,
				realMAC.replace(" ", "+"));
	}

	@GetMapping("/form")
	public FormFieldsResponseDTO getFormFields(@RequestParam String typeCanal, @RequestParam String aquereurID,
			@RequestParam String modeID, @RequestParam String canalID, @RequestParam String creancierID,
			@RequestParam String creanceID, @RequestParam String dateServeur,
			@RequestParam(required = false) String refTxSysPmt, @RequestParam String MAC) throws Exception {
		String realMAC = URLDecoder.decode(MAC, StandardCharsets.UTF_8);
		return this.debtService.getFormFields(typeCanal, aquereurID, modeID, canalID, creancierID, creanceID,
				dateServeur, refTxSysPmt, realMAC);
	}
}
