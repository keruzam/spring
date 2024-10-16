package pl.keruzam.service;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.keruzam.model.BankTransaction;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class BankTransactionService {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Long saveBankTransaction() {
		Session session = sessionFactory.getCurrentSession();
		BankTransaction bankTransaction = new BankTransaction();
		bankTransaction.setNote("note ...");
		bankTransaction.setOperationDate(new Date());
		bankTransaction.setOrderDate(new Date());
		bankTransaction.setQuota(new BigDecimal("100"));
		session.save(bankTransaction);
		return bankTransaction.getId();
	}

	public BankTransaction find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(BankTransaction.class, id);
	}
}
