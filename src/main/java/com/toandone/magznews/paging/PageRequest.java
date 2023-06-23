/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.toandone.magznews.paging;

import com.toandone.magznews.sort.Sorter;


/**
 *
 * @author LENOVO
 */
public class PageRequest implements Pageable{
    private Integer page;
    private Integer offset;
    private Integer maxItemsPerPage;
    private Sorter sorter;

    public PageRequest(Integer page, Integer maxItemsPerPage, Sorter sorter) {
        this.page = page;
        this.maxItemsPerPage = maxItemsPerPage;
        this.sorter = sorter;
    }

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public Integer getOffset() {
        return (page - 1) * maxItemsPerPage;
    }

    @Override
    public Integer getMaxItemsPerPage() {
        return maxItemsPerPage;
    }

    @Override
    public Sorter getSorter() {
        return sorter;
    }
    
}
