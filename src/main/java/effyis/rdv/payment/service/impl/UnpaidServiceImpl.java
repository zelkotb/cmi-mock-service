package effyis.rdv.payment.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import effyis.rdv.payment.dto.FormFieldDTO;
import effyis.rdv.payment.dto.UnpaidResponseDTO;
import effyis.rdv.payment.entity.Debt;
import effyis.rdv.payment.entity.Unpaid;
import effyis.rdv.payment.enumeration.FeesType;
import effyis.rdv.payment.enumeration.ReturnCode;
import effyis.rdv.payment.repository.UnpaidRepository;
import effyis.rdv.payment.service.DebtService;
import effyis.rdv.payment.service.UnpaidService;
import effyis.rdv.payment.util.Constants;
import effyis.rdv.payment.util.DateUtil;
import effyis.rdv.payment.util.SecurityUtil;

@Service
public class UnpaidServiceImpl implements UnpaidService {

	@Autowired
	private UnpaidRepository unpaidRepository;

	@Autowired
	private DebtService debtService;

	@Value("${date.format}")
	private String dateFormat;

	@Value("${security.hash.secret}")
	private String secret;

	public UnpaidResponseDTO getUnpaid(String typeCanal, String aquereurID, String modeID, String canalID,
			String outlet, String location, String creancierID, String creanceID, String dateServeur,
			String refTxSysPmt, String refTxFatourati, List<FormFieldDTO> formFields, byte[] MAC) throws Exception {
		byte[] calculatedMAC = SecurityUtil.calculateHashMAC_Unpaids(aquereurID, canalID, formFields, creanceID,
				creancierID, dateServeur, modeID, refTxSysPmt, refTxFatourati, typeCanal, this.secret);
		SecurityUtil.isMACValid(MAC, calculatedMAC, Constants.FACTORY_UNPAIDS);
		this.debtService.getCanal(typeCanal, Constants.FACTORY_UNPAIDS);
		this.debtService.isBillerExiste(creancierID, Constants.FACTORY_UNPAIDS);
		Debt debt = this.debtService.isDebtExisteAndActive(creancierID, creanceID, typeCanal);
		return this.buildResponseUnpaid(formFields, debt);
	}

	private UnpaidResponseDTO buildResponseUnpaid(List<FormFieldDTO> formFields, Debt debt)
			throws NoSuchAlgorithmException {
		UnpaidResponseDTO dto = new UnpaidResponseDTO();
		Date currentTime = new Date();
		dto.setDateServeur(DateUtil.formatDate(this.dateFormat, currentTime));
		dto.setCodeRetour(ReturnCode.C000.getReturnCode());
		dto.setMsg(ReturnCode.C000.getComment());
		dto.setTypeFrais(debt.getFeesType().name());
		dto.setValeurFrais(debt.getFeesValue());
		dto.setSeuilMinimal(debt.getSeuilMinimal());
		dto.setCodeDevise("504");
		List<Unpaid> unpaids = this.unpaidRepository
				.findByIdentifierFieldAndIdentifierFieldValue(formFields.get(0).getNomChamp(),
						formFields.get(0).getValeurChamp())
				.stream().filter(u -> u.hasUnpaid() == true).collect(Collectors.toList());
		dto.setImpayesParams(unpaids);
		dto.setMontantTotalTTC(
				this.calculateTotalAmountTTC(unpaids, debt.getFeesType(), debt.getFeesValue(), debt.getSeuilMinimal()));
		dto.setNbreCreances(unpaids.size());
		dto.setMAC(new byte[3]);
		return null;
	}

	// don't forget penality
	private String calculateTotalAmountTTC(List<Unpaid> unpaids, FeesType feesType, String feesValue,
			String seuilMinimal) {
		Double montantTotalTTC = 0.0;
		for (Unpaid unpaid : unpaids) {
			montantTotalTTC += unpaid.getPriceTTC();
		}
		if (feesType.name().equals("FORFAIT")) {
			montantTotalTTC += Double.parseDouble(feesValue);
		}
		return montantTotalTTC.toString();
	}
}
