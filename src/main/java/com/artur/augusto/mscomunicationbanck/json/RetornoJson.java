package com.artur.augusto.mscomunicationbanck.json;

import lombok.Data;

public class RetornoJson {

    private String mensagem;

    public RetornoJson() {
    }

    public RetornoJson(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
