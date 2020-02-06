package com.artur.augusto.mscomunicationbanck.service;

import com.artur.augusto.mscomunicationbanck.domain.Pagamento;
import com.artur.augusto.mscomunicationbanck.exception.PagamentoException;
import com.artur.augusto.mscomunicationbanck.json.PagamentoJson;
import com.artur.augusto.mscomunicationbanck.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private CartaoService cartaoService;

    @Transactional
    public void pagamento(PagamentoJson pagamentoJson) {

        if( !cartaoService.isValido(pagamentoJson.getCodigoSegurancaCartao(), pagamentoJson.getNroCartao()) ){
            throw new PagamentoException("Cartão inválido");
        }

        if( !cartaoService.isSaldoSuficiente(pagamentoJson.getCodigoSegurancaCartao(), pagamentoJson.getNroCartao(), pagamentoJson.getValorCompra()) ){
            throw  new PagamentoException("Cartão não possui saldo suficiente");
        }

        var pagamento = new Pagamento();
        pagamento.setValorCompra(pagamentoJson.getValorCompra());
        pagamento.setCartao(cartaoService.getCartao(pagamentoJson.getCodigoSegurancaCartao(), pagamentoJson.getNroCartao()));

        pagamentoRepository.save(pagamento);

        cartaoService.atualizarSaldo(pagamentoJson.getCodigoSegurancaCartao(), pagamentoJson.getNroCartao(), pagamentoJson.getValorCompra());
    }
}
