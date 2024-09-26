package com.cricket.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.app.Model.Extras;
import com.cricket.app.Repository.ExtrasRepository;

@Service
public class ExtrasService {

    @Autowired
    private ExtrasRepository extrasRepository;

    public List<Extras> getAllExtras() {
        return extrasRepository.findAll();
    }

    public Extras getExtrasById(Long id) {
        return extrasRepository.findById(id).orElse(null);
    }

    public Extras createExtras(Extras extras) {
        return extrasRepository.save(extras);
    }

    public Extras updateExtras(Long id, Extras extras) {
        if (extrasRepository.existsById(id)) {
            extras.setId(id);
            return extrasRepository.save(extras);
        }
        return null;
    }

    public void deleteExtras(Long id) {
        extrasRepository.deleteById(id);
    }
}
