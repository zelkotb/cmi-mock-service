package effyis.rdv.payment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import effyis.rdv.payment.enumeration.Canal;
import effyis.rdv.payment.enumeration.FeesType;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@Entity
@Table(name = "debt")
public class Debt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long id;
	@JsonProperty("codeCreance")
	@Column(name = "debt_code")
	private String debtCode;
	@JsonProperty("nomCreance")
	@Column(name = "debt_name")
	private String debtName;
	@JsonIgnore
	private boolean active;
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(name = "debt"), name = "debt_canal")
	@Column(name = "canal")
	@JsonIgnore
	private List<Canal> canals;
	@ManyToOne()
	@JoinColumn(name = "biller_id")
	@JsonIgnore
	private Biller biller;
	@JsonIgnore
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	private List<FormField> formFields;
	@JsonIgnore
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Unpaid> unpaids;
	@JsonIgnore
	private FeesType feesType;
	@JsonIgnore
	private String feesValue;
	@JsonIgnore
	private String seuilMinimal;

	public Debt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDebtCode() {
		return this.debtCode;
	}

	public void setDebtCode(String debtCode) {
		this.debtCode = debtCode;
	}

	public String getDebtName() {
		return this.debtName;
	}

	public void setDebtName(String debtName) {
		this.debtName = debtName;
	}

	public Biller getBiller() {
		return this.biller;
	}

	public void setBiller(Biller biller) {
		this.biller = biller;
	}

	public List<FormField> getFormFields() {
		return this.formFields;
	}

	public void setFormFields(List<FormField> formFields) {
		this.formFields = formFields;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Canal> getCanals() {
		return this.canals;
	}

	public void setCanals(List<Canal> canals) {
		this.canals = canals;
	}

	public List<Unpaid> getUnpaids() {
		return this.unpaids;
	}

	public void setUnpaids(List<Unpaid> unpaids) {
		this.unpaids = unpaids;
	}

	public FeesType getFeesType() {
		return this.feesType;
	}

	public void setFeesType(FeesType feesType) {
		this.feesType = feesType;
	}

	public String getFeesValue() {
		return this.feesValue;
	}

	public void setFeesValue(String feesValue) {
		this.feesValue = feesValue;
	}

	public String getSeuilMinimal() {
		return this.seuilMinimal;
	}

	public void setSeuilMinimal(String seuilMinimal) {
		this.seuilMinimal = seuilMinimal;
	}

}
