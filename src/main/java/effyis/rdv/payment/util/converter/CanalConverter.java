package effyis.rdv.payment.util.converter;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import effyis.rdv.payment.enumeration.Canal;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
@Converter(autoApply = true)
public class CanalConverter implements AttributeConverter<Canal, String> {

	@Override
	public String convertToDatabaseColumn(Canal attribute) {
		return attribute == null ? null : attribute.getCode();
	}

	@Override
	public Canal convertToEntityAttribute(String dbData) {
		return Stream.of(Canal.values()).filter(c -> c.getCode().equals(dbData)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException(dbData + " does not existe"));
	}

}
