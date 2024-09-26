package com.cricket.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.app.Model.Extras;
import com.cricket.app.Service.ExtrasService;

@RestController
@RequestMapping("/extras")
public class ExtrasController {

    @Autowired
    private ExtrasService extrasService;

    @GetMapping("/getAllExtras")
    public List<Extras> getAllExtras() {
        return extrasService.getAllExtras();
    }

    @GetMapping("/getExtraById/{id}")
    public ResponseEntity<Extras> getExtrasById(@PathVariable Long id) {
        Extras extras = extrasService.getExtrasById(id);
        return extras != null ? ResponseEntity.ok(extras) : ResponseEntity.notFound().build();
    }

    @PostMapping("/createExtras")
    public Extras createExtras(@RequestBody Extras extras) {
        return extrasService.createExtras(extras);
    }

    @PutMapping("/updateExtrasById/{id}")
    public ResponseEntity<Extras> updateExtras(@PathVariable Long id, @RequestBody Extras extras) {
        Extras updatedExtras = extrasService.updateExtras(id, extras);
        return updatedExtras != null ? ResponseEntity.ok(updatedExtras) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteExtrasById/{id}")
    public ResponseEntity<Void> deleteExtras(@PathVariable Long id) {
        extrasService.deleteExtras(id);
        return ResponseEntity.noContent().build();
    }
}
