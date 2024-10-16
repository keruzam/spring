package pl.keruzam;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.keruzam.model.BankTransaction;
import pl.keruzam.service.BankTransactionService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
		BankTransactionService bankTransactionService = ctx.getBean(BankTransactionService.class);


		System.out.println("Hello world!");
		Long id = bankTransactionService.saveBankTransaction();
		System.out.println("ID:" + id);
		BankTransaction finded = bankTransactionService.find(id);
		System.out.println("Note:" + finded.getNote());

	}

}