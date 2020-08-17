package effyis.rdv.payment.controller;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import effyis.rdv.payment.dto.BillersResponseDTO;
import effyis.rdv.payment.service.BillerService;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@RestController
@RequestMapping("/EFFYIS/api/cmi/creanciers")
public class BillerController {

	@Autowired
	private BillerService billerservice;

	@GetMapping()
	public BillersResponseDTO getBillers(@RequestParam String typeCanal, @RequestParam String aquereurID,
			@RequestParam String modeID, @RequestParam String canalID, @RequestParam String dateServeur,
			@RequestParam(required = false) String categorieCreance, @RequestParam(required = false) String refTxSysPmt,
			@RequestParam String MAC) throws Exception {

		String realMAC = URLDecoder.decode(MAC, StandardCharsets.UTF_8);
		return this.billerservice.getBillers(typeCanal, aquereurID, modeID, canalID, dateServeur, categorieCreance,
				refTxSysPmt, realMAC.replace(" ", "+"));
	}
}
