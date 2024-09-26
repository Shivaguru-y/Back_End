package com.cricket.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.app.Model.Total;
import com.cricket.app.Repository.TotalRepository;

@Service
public class TotalService {

    @Autowired
    private TotalRepository totalRepository;

    public List<Total> getAllTotals() {
        return totalRepository.findAll();
    }

    public Total getTotalById(Long id) {
        return totalRepository.findById(id).orElse(null);
    }

    public Total createTotal(Total total) {
        return totalRepository.save(total);
    }

    public Total updateTotal(Long id, Total total) {
        if (totalRepository.existsById(id)) {
            total.setId(id);
            return totalRepository.save(total);
        }
        return null;
    }

    public void deleteTotal(Long id) {
        totalRepository.deleteById(id);
    }
}
