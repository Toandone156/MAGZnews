/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.dao.impl;

import com.toandone.magznews.dao.IAccountDAO;
import com.toandone.magznews.mapper.impl.AccountMapper;
import com.toandone.magznews.model.AccountModel;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class AccountDAO extends AbstractDAO<AccountModel> implements IAccountDAO{

    @Override
    public AccountModel findByUserAndPass(String user, String pass) {
        String sql = "SELECT * FROM dbo.account INNER JOIN dbo.role ON role.id = account.roleid WHERE username = ? AND pass = ?";
        List<AccountModel> result = query(sql, new AccountMapper(), user, pass);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Long save(AccountModel account) {
        String sql = "INSERT INTO dbo.account ( username, pass, fullname, roleid) VALUES (?, ?, ?, ?)";
        return insert(sql, account.getUser(), account.getPass(), account.getFullName(), account.getRole().getId());
    }

    @Override
    public List<AccountModel> getAll() {
        String sql = "SELECT * FROM dbo.account INNER JOIN dbo.role ON role.id = account.roleid";
        return query(sql, new AccountMapper());
    }

    @Override
    public List<AccountModel> getByRoleId(Long roleId) {
        String sql = "SELECT * FROM dbo.account INNER JOIN dbo.role ON role.id = account.roleid WHERE roleid = ?";
        return query(sql, new AccountMapper(), roleId);
    }

    @Override
    public AccountModel findById(Long id) {
        String sql = "SELECT * FROM dbo.account INNER JOIN dbo.role ON role.id = account.roleid WHERE account.id = ?";
        List<AccountModel> result = query(sql, new AccountMapper(), id);
        return result != null ? result.get(0) : null;
    }

    @Override
    public void update(AccountModel acc) {
        String sql = "UPDATE dbo.account SET username = ?, pass = ?, fullname = ?, roleid = ? WHERE id = ?";
        insert(sql, acc.getUser(), 
                acc.getPass(), 
                acc.getFullName(), 
                acc.getRole().getId(), 
                acc.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM account WHERE id = ?";
        update(sql, id);
    }
}
