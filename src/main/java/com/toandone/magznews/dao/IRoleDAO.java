/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.dao;

import com.toandone.magznews.model.RoleModel;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface IRoleDAO extends GenericDAO{
    public List<RoleModel> getAll();
}
