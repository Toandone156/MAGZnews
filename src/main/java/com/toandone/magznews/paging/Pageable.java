/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.toandone.magznews.paging;

import com.toandone.magznews.sort.Sorter;

/**
 *
 * @author LENOVO
 */
public interface Pageable {
    Integer getPage();
    Integer getOffset();
    Integer getMaxItemsPerPage();
    Sorter getSorter();
}
