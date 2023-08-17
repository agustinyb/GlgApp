package com.glgweb.app.Glg;

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

    public Integer generateCorrelativo() {
       String correlativo = glgRepository.generateCorrelativo();
       correlativo = correlativo.substring(14,18);
       int num = Integer.parseInt(correlativo) + 1;

        return num ;

    }


}
