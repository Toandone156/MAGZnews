/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.service;

import com.toandone.magznews.model.AccountModel;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface IAccountService {
    public AccountModel findByUserAndPass(String user, String pass);
    public Long save(AccountModel acc);
    public List<AccountModel> getAll();
    public List<AccountModel> getByRoleId(Long roleId);
    public AccountModel findById(Long id);
    public void update(AccountModel acc);
    public void delete(Long id);
}
