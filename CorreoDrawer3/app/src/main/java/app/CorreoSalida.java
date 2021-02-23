package app;

import com.example.correodrawer.ui.Correo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import static app.Myapp.SalidaID;

public class CorreoSalida extends RealmObject {
    @PrimaryKey
    private long id;
    private String From;
    private String para;
    private String asunto;
    private String mensaje;

    public CorreoSalida() {
        this.id= SalidaID.incrementAndGet();
    }

    public CorreoSalida(String From, String asunto, String mensaje, String para) {
        this.id= SalidaID.incrementAndGet();
        this.From = From;
        this.para = para;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public Correo toCorreo()
    {
        return new Correo((int) this.id,this.para,this.asunto,this.mensaje);
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
