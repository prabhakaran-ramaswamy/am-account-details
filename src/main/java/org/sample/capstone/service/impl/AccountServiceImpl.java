package org.sample.capstone.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.sample.capstone.entity.Account;
import org.sample.capstone.entity.AccountView;
import org.sample.capstone.repository.AccountRepository;
import org.sample.capstone.service.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public void delete(AccountView accountView) {
		accountRepository.delete(convertToEntity(accountView));
	}

	@Transactional
	public List<AccountView> save(Iterable<AccountView> accountViews) {
		List<Account> entities = StreamSupport.stream(accountViews.spliterator(), false).map(this::convertToEntity)
				.collect(Collectors.toList());
		List<Account> saveAll = accountRepository.saveAll(entities);
		return StreamSupport.stream(saveAll.spliterator(), false).map(this::convertToDto).collect(Collectors.toList());
	}

	@Transactional
	public void delete(Iterable<Long> ids) {
		List<Account> toDelete = accountRepository.findAllById(ids);
		accountRepository.deleteInBatch(toDelete);
	}

	@Transactional
	public AccountView save(AccountView accountView) {
		Account account = accountRepository.save(convertToEntity(accountView));
		return convertToDto(account);
	}

	public AccountView findOne(Long id) {
		Optional<Account> findById = accountRepository.findById(id);
		return convertToDto(findById.get());
	}

	public AccountView findOneForUpdate(Long id) {
		Optional<Account> findById = accountRepository.findById(id);
		return convertToDto(findById.get());
	}

	public List<AccountView> findAll(Iterable<Long> ids) {
		List<Account> findAllById = accountRepository.findAllById(ids);
		return StreamSupport.stream(findAllById.spliterator(), false).map(this::convertToDto)
				.collect(Collectors.toList());
	}

	public List<AccountView> findAll() {
		List<Account> findAll = accountRepository.findAll();
		return StreamSupport.stream(findAll.spliterator(), false).map(this::convertToDto).collect(Collectors.toList());
	}

	public long count() {
		return accountRepository.count();
	}

	public Page<AccountView> findAll(Pageable pageable) {
		Page<Account> findAll = accountRepository.findAll(pageable);
		List<AccountView> accountViews = StreamSupport.stream(findAll.spliterator(), false).map(this::convertToDto)
				.collect(Collectors.toList());
		return new PageImpl<>(accountViews, findAll.getPageable(), accountViews.size());
	}

	public Class<AccountView> getEntityType() {
		return AccountView.class;
	}

	public Class<Long> getIdType() {
		return Long.class;
	}

	private AccountView convertToDto(Account account) {
		AccountView accountView = modelMapper.map(account, AccountView.class);
		return accountView;
	}

	private Account convertToEntity(AccountView accountView) {
		Account account = modelMapper.map(accountView, Account.class);
		return account;
	}
}
