package effyis.rdv.payment.enumeration;

import java.util.stream.Stream;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public enum Category {

	EAU_ELECTRICITE("1", "Eaux et Electricité"), TELEPHONIE_INTERNET("2", "Téléphonie et Internet"),
	TRANSPORT("3", "Moyens de Transport"), IMPOT_TAXE("4", "Impots et Taxes");

	private String code;
	private String description;

	private Category(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public static Category getCategoryByCode(String code, Exception e) throws Exception {
		return Stream.of(Category.values()).filter(c -> c.getCode().equalsIgnoreCase(code)).findFirst()
				.orElseThrow(() -> e);
	}

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
}
