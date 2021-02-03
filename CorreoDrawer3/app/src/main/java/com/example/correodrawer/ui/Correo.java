package com.example.correodrawer.ui;

public class Correo {
    private int codigo;
    private String sender;
    private String asunto;
    private String cuerpo;
    private Boolean leido;
    private String borrar;

    public Correo(int codigo, String sender, String asunto, String cuerpo, Boolean leido) {
        this.codigo = codigo;
        this.sender = sender;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.borrar = "Borrar";
        this.leido = leido;
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

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }
}
