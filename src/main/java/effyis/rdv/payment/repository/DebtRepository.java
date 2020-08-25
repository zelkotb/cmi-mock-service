package effyis.rdv.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import effyis.rdv.payment.entity.Debt;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public interface DebtRepository extends JpaRepository<Debt, Long> {

	List<Debt> findAllByBiller_BillerCode(String BillerCode);
}
