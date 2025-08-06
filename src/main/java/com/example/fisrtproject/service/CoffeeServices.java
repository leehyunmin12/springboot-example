package com.example.fisrtproject.service;

import com.example.fisrtproject.dto.CoffeeForm;
import com.example.fisrtproject.entity.Coffee;
import com.example.fisrtproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CoffeeServices {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<Coffee> index() {
        return coffeeRepository.findAll();
    }

    public Coffee find(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee create(CoffeeForm dto) {
        Coffee create = dto.ToEntity();
        if(create.getId()!=null){
            return null;
        }
        return coffeeRepository.save(create);
    }

    public Coffee update(CoffeeForm dto, Long id) {
        Coffee coffee = dto.ToEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if(target == null || id!=coffee.getId()){
            log.info("잘못된 요청입니다.");
            return null;
        }
        target.patch(coffee);
        Coffee updated = coffeeRepository.save(target);
        return updated;
    }

    public Coffee delete(Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if(target == null){
            return null;
        }
        coffeeRepository.delete(target);
        return target;
    }
}
