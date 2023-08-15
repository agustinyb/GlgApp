package com.glgweb.app.Glg;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class GlgServices {

    @Autowired
    private GlgRepository glgRepository;

    public GlgModels saveData(GlgModels glgModels) {
        return glgRepository.save(glgModels);
    }
}
