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
		String hash = SecurityUtil.calculateHashMAC_Billers_Debts("SGMA", "16", "08242020171712", "5", "", "", "4",
				"secret");
		System.err.println("hash billers : " + hash);

		String hash2 = SecurityUtil.calculateHashMAC_Billers_Debts("SGMA", "16", "08242020171712", "5", "0006", "", "4",
				"secret");
		System.err.println("hash debts : " + hash2);

		String hash3 = SecurityUtil.calculateHashMAC_FormFields("SGMA", "16", "01", "0006", "08242020171712", "5", "",
				"3", "secret");
		System.err.println("hash form : " + hash3);
	}

}
