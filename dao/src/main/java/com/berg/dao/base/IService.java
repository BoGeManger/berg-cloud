package com.berg.dao.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.github.pagehelper.PageInfo;
import com.maiyou.vo.common.PageInVo;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public interface IService<T>  extends com.baomidou.mybatisplus.extension.service.IService<T>{

    //region mybatis-plus方法重写
    @Override
    default boolean saveBatch(Collection<T> entityList) {
        return saveBatch(entityList, DEFAULT_BATCH_SIZE);
    }

    @Override
    boolean saveOrUpdate(T entity);

    @Override
    default boolean saveOrUpdateBatch(Collection<T> entityList) {
        return saveOrUpdateBatch(entityList, DEFAULT_BATCH_SIZE);
    }

    @Override
    default boolean updateBatchById(Collection<T> entityList) {
        return updateBatchById(entityList, DEFAULT_BATCH_SIZE);
    }
    //endregion

    <E> E getById(java.io.Serializable id,Class<E> cls);

    <E> E getOne(Wrapper<T> queryWrapper,Class<E> cls);

    <E> List<E> list(Wrapper<T> queryWrapper, Class<E> cls);

    <I extends PageInVo,E> PageInfo<E> page(I input, Supplier<List<E>> function);

    <E> PageInfo<E> page(int pageIndex,int pageSize, Supplier<List<E>> function);
}
