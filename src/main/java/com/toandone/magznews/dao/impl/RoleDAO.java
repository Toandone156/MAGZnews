/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.dao.impl;
import com.toandone.magznews.dao.IRoleDAO;
import com.toandone.magznews.mapper.impl.RoleMapper;
import com.toandone.magznews.model.RoleModel;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO{

    @Override
    public List<RoleModel> getAll() {
        String sql = "SELECT * FROM role";
        return query(sql, new RoleMapper());
    }
    
}
