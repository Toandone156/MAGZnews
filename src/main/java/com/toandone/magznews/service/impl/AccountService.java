/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.service.impl;

import com.toandone.magznews.dao.IAccountDAO;
import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.service.IAccountService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author LENOVO
 */
public class AccountService implements IAccountService{
    
    @Inject
    IAccountDAO account;

    @Override
    public AccountModel findByUserAndPass(String user, String pass) {
        return account.findByUserAndPass(user, pass);
    }

    @Override
    public Long save(AccountModel acc) {
        return account.save(acc);
    }

    @Override
    public List<AccountModel> getAll() {
        return account.getAll();
    }

    @Override
    public List<AccountModel> getByRoleId(Long roleId) {
        return account.getByRoleId(roleId);
    }

    @Override
    public AccountModel findById(Long l) {
        return account.findById(l);
    }

    @Override
    public void update(AccountModel am) {
        account.update(am);
    }

    @Override
    public void delete(Long l) {
        account.delete(l);
    }
    
}
