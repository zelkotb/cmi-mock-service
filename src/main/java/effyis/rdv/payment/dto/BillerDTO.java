package effyis.rdv.payment.dto;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public class BillerDTO {

	private String nomCreancier;
	private String codeCreancier;
	private String descriptionCreancier;
	private String logoPath;
	private String siteWeb;

	public String getNomCreancier() {
		return this.nomCreancier;
	}

	public void setNomCreancier(String nomCreancier) {
		this.nomCreancier = nomCreancier;
	}

	public String getCodeCreancier() {
		return this.codeCreancier;
	}

	public void setCodeCreancier(String codeCreancier) {
		this.codeCreancier = codeCreancier;
	}

	public String getDescriptionCreancier() {
		return this.descriptionCreancier;
	}

	public void setDescriptionCreancier(String descriptionCreancier) {
		this.descriptionCreancier = descriptionCreancier;
	}

	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getSiteWeb() {
		return this.siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public BillerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
