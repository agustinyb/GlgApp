package com.glgweb.app.Glg;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
@NoArgsConstructor
public class GlgControllers {

    @Autowired
    private GlgServices glgServices;

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<GlgModels> findById(@PathVariable Long id){
        Optional idOpt = glgServices.findById(id);
        if(idOpt.isPresent()){
            return ResponseEntity.ok((GlgModels) idOpt.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/saveimpo")
    public ResponseEntity<GlgModels> saveIncomeImpo(@RequestBody GlgModels glgModels, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User- Agent"));
        glgModels = glgServices.saveData(glgModels);
        return ResponseEntity.ok(glgModels);
    }

    @GetMapping("/correlativo")
    public ResponseEntity<String> generateCorrelativo() {
        String correlativo = glgServices.generateCorrelativo();
        return ResponseEntity.ok(correlativo);
    }

    @GetMapping("/findlist")
    public ResponseEntity<List<GlgModels>> loadList() {
        List<GlgModels> list = glgServices.loadList();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/updateimpo/{id}")
    public ResponseEntity<GlgModels> updateIncomeImpo(@PathVariable Long id, @RequestBody GlgModels updateGlgModels) {
        Optional<GlgModels> updateopt = glgServices.findById(id);
        if (updateopt.isPresent()) {
            GlgModels updatedGlgModel = glgServices.saveData(updateGlgModels);
            return ResponseEntity.ok(updatedGlgModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

