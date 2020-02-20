package org.sample.capstone.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.sample.capstone.entity.Account;
import org.sample.capstone.model.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountUtil {

	@Autowired
	ModelMapper modelMapper;
	
	public AccountModel copyAccountToAccountModel(Account account) {
		AccountModel accountModel = modelMapper.map(account, AccountModel.class);
	    return accountModel;
	}
	
	public Account copyAccountModelToAccount(AccountModel accountModel) {
		Account account = modelMapper.map(accountModel, Account.class);
	    return account;
	}
	
	public List<AccountModel> copyAccountsToAccountModels(List<Account> list) {
	    return list.stream()
	            .map(this::copyAccountToAccountModel)
	            .collect(Collectors.toList());
	}
	
	public List<Account> copyAccountModelsToAccounts(List<AccountModel> accountModels) {
		return accountModels.stream()
        .map(this::copyAccountModelToAccount)
        .collect(Collectors.toList());
	}
}
