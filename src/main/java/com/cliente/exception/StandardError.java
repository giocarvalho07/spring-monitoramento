package com.cliente.exception;

public class StandardError {

    private Integer status;

    private Long timestamp;

    private String mensagem;

    private StandardError(){}

    public StandardError(Integer status, Long timestamp, String mensagem) {
        this.status = status;
        this.timestamp = timestamp;
        this.mensagem = mensagem;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
