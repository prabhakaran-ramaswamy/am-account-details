package org.sample.capstone.web;
import javax.validation.Valid;

import org.sample.capstone.entity.Account;
import org.sample.capstone.exception.NotFoundException;
import org.sample.capstone.service.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;



@RestController
@RequestMapping(value = "/accounts/{account}", name = "AccountsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountsItemJsonController {


	@Autowired
    private AccountService accountService;


    @ModelAttribute
    public Account getAccount(@PathVariable("account") Long id) {
        Account account = accountService.findOne(id);
        if (account == null) {
            throw new NotFoundException(String.format("Account with identifier '%s' not found", id));
        }
        return account;
    }


    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Account account) {
        return ResponseEntity.ok(account);
    }


    public static UriComponents showURI(Account account) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(AccountsItemJsonController.class).show(account)).buildAndExpand(account.getId()).encode();
    }


    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Account storedAccount, @Valid @RequestBody Account account, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        account.setId(storedAccount.getId());
        accountService.save(account);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Account account) {
        accountService.delete(account);
        return ResponseEntity.ok().build();
    }
}
