package com.caychen.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caychen.boot.dao.PersonDao;
import com.caychen.boot.entity.Person;
import com.caychen.boot.service.IPersonService;
import org.springframework.stereotype.Service;

/**
 * @Author: Caychen
 * @Date: 2022/9/1 14:50
 * @Description:
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonDao, Person> implements IPersonService {
}
