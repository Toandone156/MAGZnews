/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.mapper.impl;

import com.toandone.magznews.mapper.IRowMapper;
import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.model.RoleModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class AccountMapper implements IRowMapper<AccountModel> {

    @Override
    public AccountModel mapRow(ResultSet rs) {
        try {
            AccountModel account = new AccountModel();
            account.setId(rs.getLong("id"));
            account.setFullName(rs.getNString("fullname"));
            account.setUser(rs.getString("username"));
            account.setPass(rs.getString("pass"));
            RoleModel role = new RoleModel();
            role.setId(rs.getLong("roleid"));
            role.setCode(rs.getString("code"));
            role.setName(rs.getNString("name"));
            account.setRole(role);
            return account;
        } catch (SQLException ex) {
            return null;
        }
    }

}
