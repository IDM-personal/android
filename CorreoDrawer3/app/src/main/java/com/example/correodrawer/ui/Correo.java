package com.example.correodrawer.ui;

public class Correo {
    private int codigo;
    private String sender;
    private String asunto;
    private String cuerpo;

    public Correo(int codigo, String sender, String asunto, String cuerpo) {
        this.codigo = codigo;
        this.sender = sender;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

}
