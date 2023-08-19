package com.glgweb.app.Glg;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "incomeimpo")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GlgModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Impo;
    private String correlativo;
    private LocalDateTime dateCreate= LocalDateTime.now();
    private String user_impo;
    private String mandantei;
    private String folder;
    private String typeof;
    private String owner;
    private String pricing;
    private String sales;
    private String executive;
    private String agent;
    private String network;
    private String incoterm;
    private String carriage;
    private String commodity;
    private String country;
    private String route;
    private String ziparea;
    private String zipcode;
    private String placeofr;
    private String pol;
    private String pod;
    private String pode;
    private String carrier;
    private String tofc;
    private String volumen;
    private String cargort;
    private String addservice;
    private String customer;
    private String shipper;
    private String consignee;
    private String notify;
    private String facturar;
    private String aduana;
    private String transport;
    private String reference;
    private String invoicen;
    private String invoicea;
    private String packing;
}
