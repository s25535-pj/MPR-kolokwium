package s25535.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {
	private final BankService bankService;

	public BankApplication(BankService bankService) {
		this.bankService = bankService;

		System.out.println(bankService.registerClient(new Client("Jan", 1000.0)));
		System.out.println(bankService.cashTransfer("Jan", 200));
		System.out.println(bankService.addMoneyToBalance("Jan", 500.0));
		System.out.println(bankService.readClientData("Jan"));

		System.out.println(bankService.addMoneyToBalance("Agata", 200));
		System.out.println(bankService.cashTransfer("jarek",1000));
	}



	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
