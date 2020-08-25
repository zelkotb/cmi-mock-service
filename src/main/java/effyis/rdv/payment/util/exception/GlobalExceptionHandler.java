package effyis.rdv.payment.util.exception;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import effyis.rdv.payment.dto.BillerDTO;
import effyis.rdv.payment.dto.BillersResponseDTO;
import effyis.rdv.payment.dto.DebtsResponseDTO;
import effyis.rdv.payment.entity.Debt;
import effyis.rdv.payment.util.DateUtil;
import effyis.rdv.payment.util.SecurityUtil;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Value("${date.format}")
	private String dateFormat;

	@Value("${security.hash.secret}")
	private String secret;

	@ExceptionHandler(BillersException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public BillersResponseDTO handleBillersException(BillersException e) throws NoSuchAlgorithmException {
		GlobalExceptionHandler.LOGGER.error(e.getMessage(), e);
		return buildBillerResponse(e);
	}

	@ExceptionHandler(DebtsException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public DebtsResponseDTO handleDebtsException(DebtsException e) throws NoSuchAlgorithmException {
		GlobalExceptionHandler.LOGGER.error(e.getMessage(), e);
		return buildDebtsResponse(e);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public void handleException(Exception e) {
		GlobalExceptionHandler.LOGGER.error(e.getMessage(), e);

	}

	private BillersResponseDTO buildBillerResponse(BillersException e) throws NoSuchAlgorithmException {
		BillersResponseDTO responseDTO = new BillersResponseDTO();
		String dateServeur = DateUtil.formatDate(this.dateFormat, new Date());
		List<BillerDTO> billers = new ArrayList<>();
		responseDTO.setDateServeur(dateServeur);
		responseDTO.setCodeRetour(e.getReturnCode());
		responseDTO.setMsg(e.getMessage());
		responseDTO.setNbreCreancier(0);
		responseDTO.setListeCreanciers(billers);
		responseDTO.setMAC(SecurityUtil.calculateBillersSendMAC(e.getReturnCode(), dateServeur, billers, this.secret));
		return responseDTO;
	}

	private DebtsResponseDTO buildDebtsResponse(DebtsException e) throws NoSuchAlgorithmException {
		DebtsResponseDTO responseDTO = new DebtsResponseDTO();
		String dateServeur = DateUtil.formatDate(this.dateFormat, new Date());
		List<Debt> debts = new ArrayList<>();
		responseDTO.setDateServeur(dateServeur);
		responseDTO.setCodeRetour(e.getReturnCode());
		responseDTO.setMsg(e.getMessage());
		responseDTO.setNbreCreance(0);
		responseDTO.setListeCreance(debts);
		responseDTO.setMAC(SecurityUtil.calculateDebtsSendMAC(e.getReturnCode(), dateServeur, debts, this.secret));
		return responseDTO;
	}

}