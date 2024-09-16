package com.poly.workshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MayTinh {

    private Long id;

    private String ma;

    private String ten;

    private Double gia;

    private String boNho;

    private String mauSac;

    private String hang;

    private String mieuTa;
}
