/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.dao;

import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.model.NewsModel;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface IAccountDAO extends GenericDAO{
    public List<AccountModel> getAll();
    public List<AccountModel> getByRoleId(Long roleId);
    public AccountModel findByUserAndPass(String user, String pass);
    public AccountModel findById(Long id);
    public Long save(AccountModel account);
    void update(AccountModel updateAcc);
    void delete(Long id);
}
