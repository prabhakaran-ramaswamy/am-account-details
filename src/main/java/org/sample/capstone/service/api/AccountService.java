package org.sample.capstone.service.api;
import java.util.List;

import org.sample.capstone.entity.AccountView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AccountService {


    public abstract AccountView findOne(Long id);

  
    public abstract void delete(AccountView accountView);


    public abstract List<AccountView> save(Iterable<AccountView> accountViews);


    public abstract void delete(Iterable<Long> ids);


    public abstract AccountView save(AccountView accountView);


    public abstract AccountView findOneForUpdate(Long id);


    public abstract List<AccountView> findAll(Iterable<Long> ids);


    public abstract List<AccountView> findAll();


    public abstract long count();


    public abstract Page<AccountView> findAll( Pageable pageable);


}
