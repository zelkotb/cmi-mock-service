package effyis.rdv.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import effyis.rdv.payment.dto.RequestUnpaidDTO;
import effyis.rdv.payment.dto.UnpaidResponseDTO;
import effyis.rdv.payment.service.UnpaidService;

@RestController
@RequestMapping("/EFFYIS/api/cmi/creances")
public class UnpaidController {

	@Autowired
	private UnpaidService unpaidService;

	@PostMapping("/impayes")
	public UnpaidResponseDTO getunpaids(@RequestBody RequestUnpaidDTO dto) throws Exception {
		return this.unpaidService.getUnpaid(dto.getTypeCanal(), dto.getAquereurID(), dto.getModeID(), dto.getCanalID(),
				dto.getOutlet(), dto.getLocation(), dto.getCreancierID(), dto.getCreanceID(), dto.getDateServeur(),
				dto.getRefTxSysPmt(), dto.getRefTxFatourati(), dto.getCreancierVals(), dto.getMAC());
	}
}
