package effyis.rdv.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "unpaid")
public class Unpaid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("idArticle")
	private String articleId;
	@JsonProperty("description")
	private String description;
	@JsonProperty("dateFacture")
	private String billDate;
	@JsonProperty("prixTTC")
	@Column(name = "pricettc")
	private double priceTTC;
	@JsonProperty("typeArticle")
	private int articleType;
	@JsonIgnore
	private String identifierField;
	@JsonIgnore
	private String identifierFieldValue;
	@JsonIgnore
	private String obligatoryField;
	@JsonIgnore
	private String obligatoryFieldValue;
	@JsonIgnore
	private boolean hasUnpaid;

	public Unpaid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticleId() {
		return this.articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBillDate() {
		return this.billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public double getPriceTTC() {
		return this.priceTTC;
	}

	public void setPriceTTC(double priceTTC) {
		this.priceTTC = priceTTC;
	}

	public int getArticleType() {
		return this.articleType;
	}

	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}

	public String getIdentifierField() {
		return this.identifierField;
	}

	public void setIdentifierField(String identifierField) {
		this.identifierField = identifierField;
	}

	public String getIdentifierFieldValue() {
		return this.identifierFieldValue;
	}

	public void setIdentifierFieldValue(String identifierFieldValue) {
		this.identifierFieldValue = identifierFieldValue;
	}

	public String getObligatoryField() {
		return this.obligatoryField;
	}

	public void setObligatoryField(String obligatoryField) {
		this.obligatoryField = obligatoryField;
	}

	public String getObligatoryFieldValue() {
		return this.obligatoryFieldValue;
	}

	public void setObligatoryFieldValue(String obligatoryFieldValue) {
		this.obligatoryFieldValue = obligatoryFieldValue;
	}

	public boolean hasUnpaid() {
		return this.hasUnpaid;
	}

	public void setHasUnpaid(boolean hasUnpaid) {
		this.hasUnpaid = hasUnpaid;
	}

}
