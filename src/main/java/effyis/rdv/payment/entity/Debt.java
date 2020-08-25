package effyis.rdv.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	private Long id;
	@JsonProperty("nomCreance")
	@Column(name = "debt_code")
	private String debtCode;
	@JsonProperty("codeCreance")
	@Column(name = "debt_name")
	private String debtName;
	@ManyToOne()
	@JoinColumn(name = "biller_id")
	@JsonIgnore
	private Biller biller;

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

}
