package effyis.rdv.payment.util.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import effyis.rdv.payment.enumeration.Category;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

	@Override
	public String convertToDatabaseColumn(Category attribute) {
		return attribute == null ? null : attribute.getCode();
	}

	@Override
	public Category convertToEntityAttribute(String dbData) {
		return Stream.of(Category.values()).filter(v -> v.getCode().equals(dbData)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException(dbData + " does not existe"));
	}

}
