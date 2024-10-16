import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pl.keruzam.AppConfig;
import pl.keruzam.model.BankTransaction;
import pl.keruzam.service.BankTransactionService;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

//@ExtendWith(SpringExtension.class) //junit5
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class HibernateConfigTest {

	@Autowired
	private BankTransactionService bankTransactionService;

	@Test
	public void testSessionFactory() {
		Long idSavedObj = bankTransactionService.saveBankTransaction();

		BankTransaction searchEntity = bankTransactionService.find(idSavedObj);


		assertNotNull("notatka pusta", searchEntity.getNote());
	}
}

