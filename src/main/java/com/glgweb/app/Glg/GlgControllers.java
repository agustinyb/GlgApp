package com.glgweb.app.Glg;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
@NoArgsConstructor
public class GlgControllers {

    @Autowired
    private GlgServices glgServices;

    @PostMapping(value = "saveimpo")
    public GlgModels saveIncomeImpo(@RequestBody GlgModels glgModels, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User- Agent"));
        return glgServices.saveData(glgModels);
    }

    @GetMapping("/correlativo")
    public String generateCorrelativo() {
        return glgServices.generateCorrelativo();
    }

    @GetMapping("/findlist")
    public List<GlgModels> loadList(){
        return glgServices.loadList();
    }

    //@PutMapping("/saveimpo")
    //public GlgModels saveIncomeImpo(@RequestBody GlgModels glgModels, @RequestHeader HttpHeaders headers) {
      //  System.out.println(headers.get("User- Agent"));
        //return glgServices.saveData(glgModels);



}


