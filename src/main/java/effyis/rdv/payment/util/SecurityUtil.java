package effyis.rdv.payment.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import effyis.rdv.payment.dto.BillerDTO;

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

	public static String calculateHashMAC(String aquereurID, String canalID, String dateServeur, String modeID,
			String refTxSysPmt, String typeCanal, String secret) throws NoSuchAlgorithmException {

		StringBuilder str = new StringBuilder(aquereurID);
		str.append(canalID).append(dateServeur).append(modeID).append(refTxSysPmt).append(typeCanal).append(secret);
		String MAC = str.toString().replace(" ", "");
		byte[] hashMAC = SecurityUtil.calculateHashInMD5(MAC);
		return Base64.getEncoder().encodeToString(hashMAC);
	}

	// name + code...? code + name ...? code... + name ...?
	public static String calculateSendMAC(String codeRetour, String dateServeur, List<BillerDTO> billers, String secret)
			throws NoSuchAlgorithmException {
		StringBuilder str = new StringBuilder(codeRetour);
		str.append(dateServeur);
		List<String> concateCodeNameBiller = billers.stream()
				.map(biller -> biller.getCodeCreancier() + biller.getNomCreancier()).collect(Collectors.toList());
		concateCodeNameBiller.forEach(c -> str.append(c));
		str.append(billers.size());
		str.append(secret);
		byte[] hashMAC = SecurityUtil.calculateHashInMD5(str.toString());
		return Base64.getEncoder().encodeToString(hashMAC);
	}
}
