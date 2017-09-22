package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;

    /**
     * 事务操作演示
     */
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(19);
        girlA.setTel("180123");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("D");
        girlB.setAge(19);
        girlB.setTel("1800123456789");
        girlRepository.save(girlB);
    }
}
