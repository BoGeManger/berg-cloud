package com.berg.dao.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class ServiceImpl<M extends BaseMapper<T>, T> extends com.baomidou.mybatisplus.extension.service.impl.ServiceImpl<M, T> implements IService<T> {

    public <E> E getById(java.io.Serializable id,Class<E> cls){
        E target = null;
        try{
            T source = getById(id);
            if(source!=null){
                target = cls.newInstance();
                BeanUtils.copyProperties(source, target);
            }
        }catch (Exception ex){
            log.error("实体转换失败:"+ex.getMessage());
        }
        return target;
    }

    public <E> E getOne(Wrapper<T> queryWrapper,Class<E> cls){
        E target = null;
        try{
            T source = getOne(queryWrapper);
            if(source!=null){
                target = cls.newInstance();
                BeanUtils.copyProperties(source, target);
            }
        }catch (Exception ex){
            log.error("实体转换失败:"+ex.getMessage());
        }
        return target;
    }

    public <E> List<E> list(Wrapper<T> queryWrapper,Class<E> cls){
        List<E> target = new ArrayList<>();
        List<T> source = list(queryWrapper);
        try{
            for (T item:source) {
                E entity = cls.newInstance();;
                BeanUtils.copyProperties(item, entity);
                target.add(entity);
            }
        }catch (Exception ex){
            log.error("实体转换失败:"+ex.getMessage());
        }
        return target;
    }
}
