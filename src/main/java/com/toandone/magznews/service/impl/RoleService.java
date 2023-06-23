/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.service.impl;

import com.toandone.magznews.dao.IRoleDAO;
import com.toandone.magznews.model.RoleModel;
import com.toandone.magznews.service.IRoleService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author LENOVO
 */
public class RoleService implements IRoleService{
    
    @Inject
    IRoleDAO role;

    @Override
    public List<RoleModel> getAll() {
        return role.getAll();
    }
    
}
