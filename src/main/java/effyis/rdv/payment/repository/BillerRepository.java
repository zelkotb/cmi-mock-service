package effyis.rdv.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import effyis.rdv.payment.entity.Biller;
import effyis.rdv.payment.enumeration.Canal;
import effyis.rdv.payment.enumeration.Category;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public interface BillerRepository extends JpaRepository<Biller, Long> {

	List<Biller> findByCategory(Category category);

	List<Biller> findByCategoryAndCanals(Category category, Canal canal);

	List<Biller> findAllByCanals(Canal canal);
}
