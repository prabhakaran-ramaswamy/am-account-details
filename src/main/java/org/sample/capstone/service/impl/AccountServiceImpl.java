package org.sample.capstone.service.impl;

import java.util.List;
import java.util.Optional;

import org.sample.capstone.entity.Account;
import org.sample.capstone.repository.AccountRepository;
import org.sample.capstone.service.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		setAccountRepository(accountRepository);
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional
	public void delete(Account account) {
		getAccountRepository().delete(account);
	}

	@Transactional
	public List<Account> save(Iterable<Account> entities) {
		return getAccountRepository().saveAll(entities);
	}

	@Transactional
	public void delete(Iterable<Long> ids) {
		List<Account> toDelete = getAccountRepository().findAllById(ids);
		getAccountRepository().deleteInBatch(toDelete);
	}

	@Transactional
	public Account save(Account entity) {
		return getAccountRepository().save(entity);
	}

	public Account findOne(Long id) {
		Optional<Account> findById = getAccountRepository().findById(id);
		return findById.get();
	}

	public Account findOneForUpdate(Long id) {
		Optional<Account> findById = getAccountRepository().findById(id);
		return findById.get();
	}

	public List<Account> findAll(Iterable<Long> ids) {
		return getAccountRepository().findAllById(ids);
	}

	public List<Account> findAll() {
		return getAccountRepository().findAll();
	}

	public long count() {
		return getAccountRepository().count();
	}

	public Page<Account> findAll(Pageable pageable) {
		return getAccountRepository().findAll(pageable);
	}

	public Class<Account> getEntityType() {
		return Account.class;
	}

	public Class<Long> getIdType() {
		return Long.class;
	}
}
