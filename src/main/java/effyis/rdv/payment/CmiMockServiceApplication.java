package effyis.rdv.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import effyis.rdv.payment.util.SecurityUtil;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@SpringBootApplication
public class CmiMockServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CmiMockServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		byte[] hash = SecurityUtil.calculateHashMAC_Billers_Debts("SGMA", "16", "08242020171712", "5", "", "", "4",
				"secret");
		for (byte b : hash) {
			System.err.println("hash billers : " + b);
		}

		byte[] hash2 = SecurityUtil.calculateHashMAC_Billers_Debts("SGMA", "16", "08242020171712", "5", "0006", "", "4",
				"secret");
		for (byte b : hash2) {
			System.err.println("hash debts : " + b);
		}

		byte[] hash3 = SecurityUtil.calculateHashMAC_FormFields("SGMA", "16", "01", "0006", "08242020171712", "5", "",
				"3", "secret");
		for (byte b : hash3) {
			System.err.println("hash form : " + b);
		}
	}

}
