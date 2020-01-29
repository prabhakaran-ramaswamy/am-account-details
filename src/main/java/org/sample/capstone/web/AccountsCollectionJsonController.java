package org.sample.capstone.web;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.sample.capstone.entity.Account;
import org.sample.capstone.helper.AccountUtil;
import org.sample.capstone.model.AccountModel;
import org.sample.capstone.service.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;


@RestController
@RequestMapping(value = "/accounts", name = "AccountsCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountsCollectionJsonController {

	@Autowired
    private AccountService accountService;


    @GetMapping(name = "list")
    public ResponseEntity<Page<AccountModel>> list(@PageableDefault Pageable pageable) {
        Page<Account> accounts = accountService.findAll( pageable);
        List<AccountModel> accountModels = AccountUtil.copyAccountsToAccountModels(accounts.getContent());
        Page<AccountModel> page = new PageImpl<>(accountModels, accounts.getPageable(), accountModels.size());
        return ResponseEntity.ok(page);
    }


    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(AccountsCollectionJsonController.class).list( null)).build().encode();
    }

    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody AccountModel accountModel, BindingResult result) {
        if (accountModel.getId() != null ) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        Account account = AccountUtil.copyAccountModelToAccount(accountModel);
        Account newAccount = accountService.save(account);
        UriComponents showURI = AccountsItemJsonController.showURI(AccountUtil.copyAccountToAccountModel(newAccount));
        return ResponseEntity.created(showURI.toUri()).build();
    }


    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<AccountModel> accountModels, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        accountService.save(AccountUtil.copyAccountModelsToAccounts(new ArrayList<AccountModel>(accountModels)));
        return ResponseEntity.created(listURI().toUri()).build();
    }


    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<AccountModel> accountModels, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        accountService.save(AccountUtil.copyAccountModelsToAccounts(new ArrayList<AccountModel>(accountModels)));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        accountService.delete(ids);
        return ResponseEntity.ok().build();
    }
}
