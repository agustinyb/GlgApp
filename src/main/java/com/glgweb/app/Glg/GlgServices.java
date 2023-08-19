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

    public String generateCorrelativo() {
       String correlativo = glgRepository.generateCorrelativo();
       Integer correnum = Integer.parseInt(correlativo);
       Integer corref = correnum + 1;
       String ulticorre = "GLG/IMPO/FCL/" + corref;
        return ulticorre ;
    }
}
