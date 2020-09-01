package effyis.rdv.payment.entity;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import effyis.rdv.payment.util.converter.StringListConverter;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@Entity
@Table(name = "form_field")
public class FormField {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long id;
	private String libelle;
	@JsonProperty("nomChamp")
	private String fieldName;
	@JsonProperty("typeChamp")
	private String fieldType;
	@Convert(converter = StringListConverter.class)
	private List<String> listVals;
	@JsonProperty("formatChamp")
	private String fieldFormat;
	@JsonProperty("tailleMin")
	private int minSize;
	@JsonProperty("tailleMax")
	private int maxSize;
	private String contrainte;

	public FormField() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public List<String> getListVals() {
		return this.listVals;
	}

	public void setListVals(List<String> listVals) {
		this.listVals = listVals;
	}

	public String getFieldFormat() {
		return this.fieldFormat;
	}

	public void setFieldFormat(String fieldFormat) {
		this.fieldFormat = fieldFormat;
	}

	public int getMinSize() {
		return this.minSize;
	}

	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}

	public int getMaxSize() {
		return this.maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public String getContrainte() {
		return this.contrainte;
	}

	public void setContrainte(String contrainte) {
		this.contrainte = contrainte;
	}

}
