package effyis.rdv.payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import effyis.rdv.payment.dto.BillersResponseDTO;
import effyis.rdv.payment.dto.RequestDTO;
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

	@PostMapping()
	public BillersResponseDTO getBillers(@Valid @RequestBody RequestDTO requestDTO,
			@RequestParam(required = false) String categorieCreance) throws Exception {
		return this.billerservice.getBillers(requestDTO.getTypeCanal(), requestDTO.getAquereurID(),
				requestDTO.getModeID(), requestDTO.getCanalID(), requestDTO.getDateServeur(), categorieCreance,
				requestDTO.getRefTxSysPmt(), requestDTO.getMAC());
	}
}
