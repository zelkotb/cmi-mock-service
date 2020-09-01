package effyis.rdv.payment.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import effyis.rdv.payment.enumeration.Canal;
import effyis.rdv.payment.enumeration.Category;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */

@Entity
@Table(name = "biller")
public class Biller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long id;
	@JsonProperty("nomCreancier")
	@Column(name = "biller_name")
	private String billerName;
	@JsonProperty("codeCreancier")
	@Column(name = "biller_code")
	private String billerCode;
	@JsonProperty("descriptionCreancier")
	@Column(name = "biller_description")
	private String billerDescription;
	@Column(name = "logo_path")
	private String logoPath;
	@JsonProperty("siteWeb")
	private String website;
	@JsonProperty(value = "categorieCreance", access = Access.WRITE_ONLY)
	private Category category;
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(name = "biller"), name = "biller_canal")
	@Column(name = "canal")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Canal> canals;
	@OneToMany(mappedBy = "biller", orphanRemoval = true)
	@JsonIgnore()
	private List<Debt> debts;

	public Biller() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillerName() {
		return this.billerName;
	}

	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}

	public String getBillerCode() {
		return this.billerCode;
	}

	public void setBillerCode(String billerCode) {
		this.billerCode = billerCode;
	}

	public String getBillerDescription() {
		return this.billerDescription;
	}

	public void setBillerDescription(String billerDescription) {
		this.billerDescription = billerDescription;
	}

	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Canal> getCanals() {
		return this.canals;
	}

	public void setCanal(List<Canal> canals) {
		this.canals = canals;
	}

	public List<Debt> getDebts() {
		return this.debts;
	}

	public void setDebts(List<Debt> debts) {
		this.debts = debts;
	}

	public void setCanals(List<Canal> canals) {
		this.canals = canals;
	}

}
