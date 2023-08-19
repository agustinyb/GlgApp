package com.glgweb.app.Glg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GlgRepository extends JpaRepository <GlgModels,Long> {

@Query (value = "SELECT COUNT(correlativo) FROM incomeimpo", nativeQuery = true)
String generateCorrelativo ();
}
