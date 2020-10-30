package effyis.rdv.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import effyis.rdv.payment.dto.RequestUnpaidDTO;
import effyis.rdv.payment.service.UnpaidService;

@RestController
@RequestMapping("/EFFYIS/api/cmi/impayes")
public class UmpaidController {

	@Autowired
	private UnpaidService unpaidService;

	@PostMapping("/impayes")
	public void getImpayesFields(@RequestBody RequestUnpaidDTO dto) throws Exception {

	}
}
