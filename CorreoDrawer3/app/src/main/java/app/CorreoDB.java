package app;

import java.util.concurrent.atomic.AtomicLong;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

import static app.Myapp.CorreoID;

public class CorreoDB extends RealmObject {
    @PrimaryKey
    private long id;
    private String mail;
    private String nombre;
    private String asunto;
    private String mensaje;
    private int type;
    public CorreoDB() {
        this.id= CorreoID.incrementAndGet();
    }
    public CorreoDB(String mail, String nombre, String asunto, String mensaje) {
        this.id= CorreoID.incrementAndGet();
        this.mail = mail;
        this.nombre = nombre;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }
}
