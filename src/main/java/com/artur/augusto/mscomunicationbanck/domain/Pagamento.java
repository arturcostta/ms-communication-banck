package com.artur.augusto.mscomunicationbanck.domain;

import com.artur.augusto.mscomunicationbanck.domain.Cartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="pagamento")
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Cartao cartao;

    private BigDecimal valorCompra;
}
