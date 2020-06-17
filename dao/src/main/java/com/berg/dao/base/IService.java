package com.berg.dao.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;

public interface IService<T>  extends com.baomidou.mybatisplus.extension.service.IService<T>{

    <E> E getById(java.io.Serializable id,Class<E> cls);

    <E> E getOne(Wrapper<T> queryWrapper,Class<E> cls);

    <E> List<E> list(Wrapper<T> queryWrapper, Class<E> cls);
}
