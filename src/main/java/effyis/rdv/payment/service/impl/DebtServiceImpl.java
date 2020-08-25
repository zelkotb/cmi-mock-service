package effyis.rdv.payment.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import effyis.rdv.payment.dto.DebtsResponseDTO;
import effyis.rdv.payment.entity.Biller;
import effyis.rdv.payment.entity.Debt;
import effyis.rdv.payment.enumeration.Canal;
import effyis.rdv.payment.enumeration.ReturnCode;
import effyis.rdv.payment.repository.BillerRepository;
import effyis.rdv.payment.repository.DebtRepository;
import effyis.rdv.payment.service.DebtService;
import effyis.rdv.payment.util.DateUtil;
import effyis.rdv.payment.util.SecurityUtil;
import effyis.rdv.payment.util.exception.DebtsException;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@Service
public class DebtServiceImpl implements DebtService {

	@Autowired
	private DebtRepository debtRepository;

	@Autowired
	private BillerRepository billerRepository;

	@Value("${date.format}")
	private String dateFormat;

	@Value("${security.hash.secret}")
	private String secret;

	// reste canal
	@Override
	public DebtsResponseDTO getDebts(String typeCanal, String aquereurID, String modeID, String canalID,
			String creancierID, String dateServeur, String categorieCreance, String refTxSysPmt, String MAC)
			throws Exception {
		String calculatedMAC = SecurityUtil.calculateHashMAC(aquereurID, canalID, dateServeur, modeID, creancierID,
				refTxSysPmt, typeCanal, this.secret);
		SecurityUtil.isMACValid(MAC, calculatedMAC, "debts");
		getCanal(typeCanal);
		isBillerExiste(creancierID);
		List<Debt> debts = this.debtRepository.findAllByBiller_BillerCode(creancierID);
		return buildResponse(debts);
	}

	private Canal getCanal(String typeCanal) throws Exception {
		DebtsException e = new DebtsException(ReturnCode.C113.getReturnCode(), ReturnCode.C113.getComment());
		Canal canal = Canal.getCanalByCode(typeCanal, e);
		return canal;
	}

	private void isBillerExiste(String creancierID) {
		Biller biller = this.billerRepository.findByBillerCode(creancierID);
		if (biller == null) {
			throw new DebtsException(ReturnCode.C104.getReturnCode(), ReturnCode.C104.getComment());
		}
	}

	private DebtsResponseDTO buildResponse(List<Debt> debts) throws NoSuchAlgorithmException {
		DebtsResponseDTO debtsResponseDTO = new DebtsResponseDTO();
		Date currentTime = new Date();
		debtsResponseDTO.setDateServeur(DateUtil.formatDate(this.dateFormat, currentTime));
		debtsResponseDTO.setCodeRetour(ReturnCode.C000.getReturnCode());
		debtsResponseDTO.setMsg(ReturnCode.C000.getComment());
		debtsResponseDTO.setNbreCreance(debts.size());
		debtsResponseDTO.setListeCreance(debts);
		debtsResponseDTO.setMAC(SecurityUtil.calculateDebtsSendMAC(ReturnCode.C000.getReturnCode(),
				DateUtil.formatDate(this.dateFormat, currentTime), debts, this.secret));
		return debtsResponseDTO;
	}
}
