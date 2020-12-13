package com.mortymaroon.spring.mvc.services;

import com.mortymaroon.spring.mvc.model.Box;
import com.mortymaroon.spring.mvc.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoxService {
    private BoxRepository boxRepository;

    @Autowired
    public void setBoxRepository(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    public List<Box> getAllBox() {
        return boxRepository.getAllBoxes();
    }

    public void save(Box box) {
        boxRepository.save(box);
    }

    public void deleteById(Long id) {
        boxRepository.deleteById(id);
    }
}
