/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.mapper.impl;

import com.toandone.magznews.mapper.IRowMapper;
import com.toandone.magznews.model.RoleModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class RoleMapper implements IRowMapper<RoleModel>{

    @Override
    public RoleModel mapRow(ResultSet rs) {
        try {
            RoleModel role = new RoleModel();
            role.setId(rs.getLong("id"));
            role.setCode(rs.getString("code"));
            role.setName(rs.getNString("name"));
            return role;
        } catch (SQLException ex) {
            Logger.getLogger(RoleMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
