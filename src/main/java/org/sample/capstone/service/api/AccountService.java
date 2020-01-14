package org.sample.capstone.service.api;
import java.util.List;

import org.sample.capstone.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AccountService {


    public abstract Account findOne(Long id);

  
    public abstract void delete(Account account);


    public abstract List<Account> save(Iterable<Account> entities);


    public abstract void delete(Iterable<Long> ids);


    public abstract Account save(Account entity);


    public abstract Account findOneForUpdate(Long id);


    public abstract List<Account> findAll(Iterable<Long> ids);


    public abstract List<Account> findAll();


    public abstract long count();


    public abstract Page<Account> findAll( Pageable pageable);


}
