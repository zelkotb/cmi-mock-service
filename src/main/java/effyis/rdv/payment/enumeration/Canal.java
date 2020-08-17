package effyis.rdv.payment.enumeration;

import java.util.stream.Stream;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public enum Canal {

	GA("1", "GA"), MO("2", "MO"), IN("3", "IN"), AG("4", "AG");

	private String code;
	private String name;

	private Canal(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public static Canal getCanalByCode(String code, Exception e) throws Exception {
		return Stream.of(Canal.values()).filter(c -> c.getCode().equalsIgnoreCase(code)).findFirst()
				.orElseThrow(() -> e);
	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

}
