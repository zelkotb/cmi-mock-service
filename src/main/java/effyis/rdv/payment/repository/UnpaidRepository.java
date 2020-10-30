package effyis.rdv.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import effyis.rdv.payment.entity.Unpaid;

public interface UnpaidRepository extends JpaRepository<Unpaid, Long> {

	List<Unpaid> findByIdentifierFieldAndIdentifierFieldValue(String identifierField, String identifierFieldValue);
}
