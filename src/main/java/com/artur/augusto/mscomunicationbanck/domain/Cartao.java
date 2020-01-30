package com.artur.augusto.mscomunicationbanck.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="cartao")
@AllArgsConstructor
@NoArgsConstructor
public class Cartao {
    @Id
    @GeneratedValue
    private Long id;
    private Integer nroCartao;
    private Integer codigoSegurancaCartao;
    private BigDecimal valorCredito;
}
