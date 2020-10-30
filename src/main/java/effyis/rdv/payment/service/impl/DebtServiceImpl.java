package effyis.rdv.payment.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import effyis.rdv.payment.dto.DebtsResponseDTO;
import effyis.rdv.payment.dto.FormFieldsResponseDTO;
import effyis.rdv.payment.entity.Biller;
import effyis.rdv.payment.entity.Debt;
import effyis.rdv.payment.entity.FormField;
import effyis.rdv.payment.enumeration.Canal;
import effyis.rdv.payment.enumeration.ReturnCode;
import effyis.rdv.payment.repository.BillerRepository;
import effyis.rdv.payment.repository.DebtRepository;
import effyis.rdv.payment.service.DebtService;
import effyis.rdv.payment.util.Constants;
import effyis.rdv.payment.util.DateUtil;
import effyis.rdv.payment.util.SecurityUtil;
import effyis.rdv.payment.util.exception.ExceptionFactory;
import effyis.rdv.payment.util.exception.FormFieldException;

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

	@Override
	public DebtsResponseDTO getDebts(String typeCanal, String aquereurID, String modeID, String canalID,
			String creancierID, String dateServeur, String refTxSysPmt, byte[] MAC) throws Exception {
		byte[] calculatedMAC = SecurityUtil.calculateHashMAC_Billers_Debts(aquereurID, canalID, dateServeur, modeID,
				creancierID, refTxSysPmt, typeCanal, this.secret);
		SecurityUtil.isMACValid(MAC, calculatedMAC, Constants.FACTORY_DEBTS);
		this.getCanal(typeCanal, Constants.FACTORY_DEBTS);
		this.isBillerExiste(creancierID, Constants.FACTORY_DEBTS);
		List<Debt> debts = this.debtRepository.findAllByBiller_BillerCode(creancierID);
		return this.buildResponseDebts(debts);
	}

	@Override
	public FormFieldsResponseDTO getFormFields(String typeCanal, String aquereurID, String modeID, String canalID,
			String creancierID, String creanceID, String dateServeur, String refTxSysPmt, byte[] MAC) throws Exception {
		byte[] calculatedMAC = SecurityUtil.calculateHashMAC_FormFields(aquereurID, canalID, creanceID, creancierID,
				dateServeur, modeID, refTxSysPmt, typeCanal, this.secret);
		SecurityUtil.isMACValid(MAC, calculatedMAC, Constants.FACTORY_FORMFIELDS);
		this.getCanal(typeCanal, Constants.FACTORY_FORMFIELDS);
		this.isBillerExiste(creancierID, Constants.FACTORY_FORMFIELDS);
		Debt debt = this.isDebtExisteAndActive(creancierID, creanceID, typeCanal);
		this.isFormEmpty(debt.getFormFields());
		return this.buildResponseFormFields(debt.getFormFields());
	}

	@Override
	public Canal getCanal(String typeCanal, String type) throws Exception {
		ExceptionFactory factory = new ExceptionFactory();
		Canal canal = Canal.getCanalByCode(typeCanal,
				factory.getException(type, ReturnCode.C113.getReturnCode(), ReturnCode.C113.getComment()));
		return canal;
	}

	@Override
	public void isBillerExiste(String creancierID, String type) throws Exception {
		Biller biller = this.billerRepository.findByBillerCode(creancierID);
		if (biller == null) {
			ExceptionFactory factory = new ExceptionFactory();
			throw factory.getException(type, ReturnCode.C104.getReturnCode(), ReturnCode.C104.getComment());
		}
	}

	@Override
	public Debt isDebtExisteAndActive(String creancierID, String creanceID, String typeCanal) {
		List<Debt> debts = this.debtRepository.findAllByBiller_BillerCode(creancierID);
		Debt debt = debts.stream().filter(d -> d.getDebtCode().equals(creanceID)).findFirst().orElseThrow(
				() -> new FormFieldException(ReturnCode.C105.getReturnCode(), ReturnCode.C105.getComment()));
		if (!debt.isActive()) {
			throw new FormFieldException(ReturnCode.C103.getReturnCode(), ReturnCode.C103.getComment());
		}
		debt.getCanals().stream().filter(c -> c.getCode().equals(typeCanal)).findFirst().orElseThrow(
				() -> new FormFieldException(ReturnCode.C102.getReturnCode(), ReturnCode.C102.getComment()));
		return debt;
	}

	private void isFormEmpty(List<FormField> formFields) {
		if (formFields.isEmpty() || (formFields == null)) {
			throw new FormFieldException(ReturnCode.C111.getReturnCode(), ReturnCode.C111.getComment());
		}
	}

	private DebtsResponseDTO buildResponseDebts(List<Debt> debts) throws NoSuchAlgorithmException {
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

	private FormFieldsResponseDTO buildResponseFormFields(List<FormField> formFields) throws NoSuchAlgorithmException {
		FormFieldsResponseDTO formFieldsResponseDTO = new FormFieldsResponseDTO();
		Date currentTime = new Date();
		formFieldsResponseDTO.setDateServeur(DateUtil.formatDate(this.dateFormat, currentTime));
		formFieldsResponseDTO.setCodeRetour(ReturnCode.C000.getReturnCode());
		formFieldsResponseDTO.setMsg(ReturnCode.C000.getComment());
		formFieldsResponseDTO.setNbreParams(formFields.size());
		formFieldsResponseDTO.setCreancierParams(formFields);
		formFieldsResponseDTO.setRefTxFatourati("");
		formFieldsResponseDTO.setMAC(SecurityUtil.calculateFormFieldsSendMAC(ReturnCode.C000.getReturnCode(),
				DateUtil.formatDate(this.dateFormat, currentTime), formFields, this.secret));
		return formFieldsResponseDTO;
	}
}
