package int371.project.EventMod.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import int371.project.EventMod.Exceptions.EventsException;
import int371.project.EventMod.Exceptions.ExceptionResponse;
import int371.project.EventMod.Models.Accounts;
import int371.project.EventMod.Models.Events;
import int371.project.EventMod.Repositories.AccountsJpaRepository;

@CrossOrigin
@RestController
public class AccountsController {
	@Autowired
	private AccountsJpaRepository accountsJpa;

////-------------------------------------------------------- GetMapping -------------------------------------------------------------------------
	// Show a list of all accounts.
	@GetMapping("/accounts")
	public List<Accounts> showAllAccounts() {
		return accountsJpa.findAll();
	}

	// Show list of accounts by accountID
	@GetMapping("/accounts/{accountID}")
	public Accounts showAccountByID(@PathVariable int accountID) {
		Accounts account = this.accountsJpa.findById(accountID).orElse(null);
		if (account == null) {
			throw new EventsException(ExceptionResponse.ERROR_CODE.ACCOUNT_ID_DOES_NOT_EXIST,
					"Account ID" + " : " + accountID + " " + "does not exist");
		}
		return account;
	}
}