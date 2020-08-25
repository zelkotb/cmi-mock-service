package effyis.rdv.payment.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import effyis.rdv.payment.dto.BillerDTO;
import effyis.rdv.payment.dto.BillersResponseDTO;
import effyis.rdv.payment.entity.Biller;
import effyis.rdv.payment.enumeration.Canal;
import effyis.rdv.payment.enumeration.Category;
import effyis.rdv.payment.enumeration.ReturnCode;
import effyis.rdv.payment.repository.BillerRepository;
import effyis.rdv.payment.service.BillerService;
import effyis.rdv.payment.util.DateUtil;
import effyis.rdv.payment.util.SecurityUtil;
import effyis.rdv.payment.util.exception.BillersException;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@Service
public class BillerServiceImpl implements BillerService {

	@Autowired
	private BillerRepository billerRepository;

	@Value("${date.format}")
	private String dateFormat;

	@Value("${security.hash.secret}")
	private String secret;

	@Override
	public BillersResponseDTO getBillers(String typeCanal, String aquereurID, String modeID, String canalID,
			String dateServeur, String categorieCreance, String refTxSysPmt, String MAC) throws Exception {

		String calculatedMAC = SecurityUtil.calculateHashMAC(aquereurID, canalID, dateServeur, modeID, "", refTxSysPmt,
				typeCanal, this.secret);
		SecurityUtil.isMACValid(MAC, calculatedMAC, "billers");
		List<Biller> billers;
		Category category;
		Canal canal = getCanal(typeCanal);
		// check if category exist
		if ((categorieCreance != null) && (categorieCreance != "")) {
			category = getCategory(categorieCreance);
			billers = this.billerRepository.findByCategoryAndCanals(category, canal);
		} else {
			billers = this.billerRepository.findAllByCanals(canal);
		}
		return buildResponse(billers);
	}

	private BillersResponseDTO buildResponse(List<Biller> billers) throws NoSuchAlgorithmException {
		BillersResponseDTO billersResponseDTO = new BillersResponseDTO();
		Date currentTime = new Date();
		billersResponseDTO.setDateServeur(DateUtil.formatDate(this.dateFormat, currentTime));
		billersResponseDTO.setCodeRetour(ReturnCode.C000.getReturnCode());
		billersResponseDTO.setMsg(ReturnCode.C000.getComment());
		billersResponseDTO.setNbreCreancier(billers.size());
		List<BillerDTO> billersDTO = billers.stream().map(this::buildBuillerDTO).collect(Collectors.toList());
		billersResponseDTO.setListeCreanciers(billersDTO);
		billersResponseDTO.setMAC(SecurityUtil.calculateBillersSendMAC(ReturnCode.C000.getReturnCode(),
				DateUtil.formatDate(this.dateFormat, currentTime), billersDTO, this.secret));
		return billersResponseDTO;
	}

	private BillerDTO buildBuillerDTO(Biller biller) {
		BillerDTO billerDTO = new BillerDTO();
		billerDTO.setNomCreancier(biller.getBillerName());
		billerDTO.setCodeCreancier(biller.getBillerCode());
		billerDTO.setDescriptionCreancier(biller.getBillerDescription());
		billerDTO.setLogoPath(biller.getLogoPath());
		billerDTO.setSiteWeb(biller.getWebsite());
		return billerDTO;
	}

	private Category getCategory(String categorieCreance) throws Exception {
		BillersException e = new BillersException(ReturnCode.C112.getReturnCode(), ReturnCode.C112.getComment());
		return Category.getCategoryByCode(categorieCreance, e);
	}

	private Canal getCanal(String typeCanal) throws Exception {
		BillersException e = new BillersException(ReturnCode.C113.getReturnCode(), ReturnCode.C113.getComment());
		Canal canal = Canal.getCanalByCode(typeCanal, e);
		return canal;
	}

}
