package com.glgweb.app.Glg;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return ulticorre;
    }

    public List<GlgModels> loadList() {
        return glgRepository.loadList();
    }

    public Optional<GlgModels> findById(Long id) {
        return glgRepository.findById(id);
    }

    public void deleteById(Long id) {
        glgRepository.deleteById(id);
    }

    public void deleteAll() {
        glgRepository.deleteAll();
    }

    public List<GlgModels> findAll() {
        List <GlgModels>  glgRet = glgRepository.findAll();
        return glgRet;
    }

}
