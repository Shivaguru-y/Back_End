package com.cricket.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.app.Model.Total;
import com.cricket.app.Service.TotalService;

@RestController
@CrossOrigin("*") 
@RequestMapping("/totals")
public class TotalController {

    @Autowired
    private TotalService totalService;

    @GetMapping("/getAllTotals")
    public List<Total> getAllTotals() {
        return totalService.getAllTotals();
    }

    @GetMapping("/getTotalById/{id}")
    public ResponseEntity<Total> getTotalById(@PathVariable Long id) {
        Total total = totalService.getTotalById(id);
        return total != null ? ResponseEntity.ok(total) : ResponseEntity.notFound().build();
    }

    @PostMapping("/createTotal")
    public Total createTotal(@RequestBody Total total) {
        return totalService.createTotal(total);
    }

    @PutMapping("/updateTotalById/{id}")
    public ResponseEntity<Total> updateTotal(@PathVariable Long id, @RequestBody Total total) {
        Total updatedTotal = totalService.updateTotal(id, total);
        return updatedTotal != null ? ResponseEntity.ok(updatedTotal) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteTotalById/{id}")
    public ResponseEntity<Void> deleteTotal(@PathVariable Long id) {
        totalService.deleteTotal(id);
        return ResponseEntity.noContent().build();
    }
}
