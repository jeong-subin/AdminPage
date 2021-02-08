package com.fast.study.service;

import com.fast.study.ifs.CrudInterface;
import com.fast.study.model.network.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
@Component
public abstract class BaseService<Req,Res,Entity> implements CrudInterface<Req,Res> {


    @Autowired(required = false)
    protected JpaRepository<Entity,Long> baseRepository;
    //JpaRepository<Item,Long>
}
