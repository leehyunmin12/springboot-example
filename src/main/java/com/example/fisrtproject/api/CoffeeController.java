package com.example.fisrtproject.api;

import com.example.fisrtproject.dto.CoffeeForm;
import com.example.fisrtproject.entity.Coffee;
import com.example.fisrtproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CoffeeController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("/api/coffees")
    public List<Coffee> index() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/api/coffee/{id}")
    public Coffee find(@PathVariable Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/coffees")
    public Coffee create(@RequestBody CoffeeForm dto) {
        Coffee coffee = dto.ToEntity();
        return coffeeRepository.save(coffee);
    }

    @PatchMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> update(@RequestBody CoffeeForm dto, @PathVariable Long id) {
        Coffee coffee = dto.ToEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if(target == null || id!=coffee.getId()){
            log.info("잘못된 요청입니다.");
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        target.patch(coffee);
        Coffee updated = coffeeRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id){
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if(target == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        coffeeRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
