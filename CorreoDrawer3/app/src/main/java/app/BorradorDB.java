package app;

import com.example.correodrawer.ui.Correo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import static app.Myapp.BorradorID;
import static app.Myapp.CorreoID;

public class BorradorDB extends RealmObject {
    @PrimaryKey
    private long id;
    private String para;
    private String From;
    private String asunto;
    private String mensaje;

    public BorradorDB() {
        this.id= BorradorID.incrementAndGet();
    }
    public BorradorDB(String para, String nombre, String asunto, String mensaje) {
        this.id= CorreoID.incrementAndGet();
        this.From = From;
        this.para = para;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public Correo toCorreo()
    {
        return new Correo((int) this.id,this.From,this.asunto,this.mensaje);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
