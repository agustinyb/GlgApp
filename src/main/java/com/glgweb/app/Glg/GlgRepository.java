package com.glgweb.app.Glg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface GlgRepository extends JpaRepository<GlgModels, Long> {

    @Query(value = "SELECT COUNT(correlativo) FROM incomeimpo", nativeQuery = true)
    String generateCorrelativo();

    @Query(value = "select * from incomeimpo where correlativo = '{correlativo}';", nativeQuery = true)
    String findForCorrelativo(String correlativo);

    @Query(value = "select * from incomeimpo", nativeQuery = true)
    List<GlgModels> loadList();


}
