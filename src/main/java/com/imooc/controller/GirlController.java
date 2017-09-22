package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setWeixin(girl.getWeixin());
        girl.setTel(girl.getTel());

        return girlRepository.save(girl);

    }

    /**
     * 查找一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable(value = "id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生
     * @param id
     * @param cupSize
     * @param age
     * @param weixin
     * @param tel
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable(value = "id") Integer id,
                           @RequestParam(value = "cupSize") String cupSize,
                           @RequestParam(value = "age") Integer age,
                           @RequestParam(value = "weixin") String weixin,
                           @RequestParam(value = "tel") String tel) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setWeixin(weixin);
        girl.setTel(tel);

        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable(value = "id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 根据年龄查询女生
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable(value = "age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }
}
