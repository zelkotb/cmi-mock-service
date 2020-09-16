package effyis.rdv.payment.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import effyis.rdv.payment.dto.BillerDTO;
import effyis.rdv.payment.entity.Debt;
import effyis.rdv.payment.entity.FormField;
import effyis.rdv.payment.enumeration.ReturnCode;
import effyis.rdv.payment.util.exception.ExceptionFactory;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */

public class SecurityUtil {

	public static byte[] calculateHashInMD5(String value) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(value.getBytes());
		return md.digest();
	}

	public static byte[] calculateHashMAC_Billers_Debts(String aquereurID, String canalID, String dateServeur,
			String modeID, String creancierID, String refTxSysPmt, String typeCanal, String secret)
			throws NoSuchAlgorithmException {

		StringBuilder str = new StringBuilder(aquereurID);
		refTxSysPmt = refTxSysPmt == null ? "" : refTxSysPmt;
		creancierID = creancierID == null ? "" : creancierID;
		str.append(canalID).append(dateServeur).append(modeID).append(creancierID).append(refTxSysPmt).append(typeCanal)
				.append(secret);
		return SecurityUtil.calculateHashInMD5(str.toString());
	}

	public static byte[] calculateHashMAC_FormFields(String aquereurID, String canalID, String creanceID,
			String creancierID, String dateServeur, String modeID, String refTxSysPmt, String typeCanal, String secret)
			throws NoSuchAlgorithmException {

		StringBuilder str = new StringBuilder(aquereurID);
		refTxSysPmt = refTxSysPmt == null ? "" : refTxSysPmt;
		creancierID = creancierID == null ? "" : creancierID;
		creanceID = creanceID == null ? "" : creanceID;
		str.append(canalID).append(creancierID).append(creanceID).append(dateServeur).append(modeID).append(refTxSysPmt)
				.append(typeCanal).append(secret);
		return SecurityUtil.calculateHashInMD5(str.toString());
	}

	// name + code...? code + name ...? code... + name ...?
	public static byte[] calculateBillersSendMAC(String codeRetour, String dateServeur, List<BillerDTO> billers,
			String secret) throws NoSuchAlgorithmException {
		StringBuilder str = new StringBuilder(codeRetour);
		str.append(dateServeur);
		List<String> concateCodeNameBiller = billers.stream()
				.map(biller -> biller.getCodeCreancier() + biller.getNomCreancier()).collect(Collectors.toList());
		concateCodeNameBiller.forEach(c -> str.append(c));
		str.append(billers.size());
		str.append(secret);
		return SecurityUtil.calculateHashInMD5(str.toString());
	}

	public static byte[] calculateDebtsSendMAC(String codeRetour, String dateServeur, List<Debt> debts, String secret)
			throws NoSuchAlgorithmException {
		StringBuilder str = new StringBuilder(codeRetour);
		str.append(dateServeur);
		List<String> concateCodeNameDebt = debts.stream().map(debt -> debt.getDebtCode() + debt.getDebtName())
				.collect(Collectors.toList());
		concateCodeNameDebt.forEach(c -> str.append(c));
		str.append(debts.size());
		str.append(secret);
		return SecurityUtil.calculateHashInMD5(str.toString());
	}

	public static byte[] calculateFormFieldsSendMAC(String codeRetour, String dateServeur, List<FormField> formFields,
			String secret) throws NoSuchAlgorithmException {
		StringBuilder str = new StringBuilder(codeRetour);
		str.append(dateServeur);
		List<String> concateCodeNameDebt = formFields.stream().map(FormField::getFieldName)
				.collect(Collectors.toList());
		concateCodeNameDebt.forEach(c -> str.append(c));
		str.append(formFields.size());
		str.append(secret);
		return SecurityUtil.calculateHashInMD5(str.toString());
	}

	public static boolean isMACValid(byte[] MAC, byte[] calculatedMAC, String exceptionType) throws Exception {
		if (Arrays.equals(calculatedMAC, MAC)) {
			return true;
		} else {
			ExceptionFactory factory = new ExceptionFactory();
			throw factory.getException(exceptionType, ReturnCode.C100.getReturnCode(), ReturnCode.C100.getComment());
		}
	}
}
