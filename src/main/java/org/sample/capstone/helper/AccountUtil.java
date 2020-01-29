package org.sample.capstone.helper;

import java.util.List;

import org.sample.capstone.HibernateProxyTypeAdapter;
import org.sample.capstone.entity.Account;
import org.sample.capstone.model.AccountModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AccountUtil {

	public static AccountModel copyAccountToAccountModel(Account account) {
	    GsonBuilder b = new GsonBuilder();
	    b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
	    Gson gson = b.create();
	    String text = gson.toJson(account);
	    AccountModel newObject = gson.fromJson(text, AccountModel.class);
	    return newObject;
	}
	
	public static Account copyAccountModelToAccount(AccountModel accountModel) {
	    GsonBuilder b = new GsonBuilder();
	    b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
	    Gson gson = b.create();
	    String text = gson.toJson(accountModel);
	    Account newObject = gson.fromJson(text, Account.class);
	    return newObject;
	}
	
	public static List<AccountModel> copyAccountsToAccountModels(List<Account> list) {
	    GsonBuilder b = new GsonBuilder();
	    b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
	    Gson gson = b.create();
	    String text = gson.toJson(list);
	    TypeToken<List<AccountModel>> token = new TypeToken<List<AccountModel>>() {};
	    List<AccountModel> newObject = gson.fromJson(text, token.getType());
	    return newObject;
	}
	
	public static List<Account> copyAccountModelsToAccounts(List<AccountModel> accountModels) {
	    GsonBuilder b = new GsonBuilder();
	    b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
	    Gson gson = b.create();
	    String text = gson.toJson(accountModels);
	    TypeToken<List<Account>> token = new TypeToken<List<Account>>() {};
	    List<Account> newObject = gson.fromJson(text, token.getType());
	    return newObject;
	}
}
