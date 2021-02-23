package app;

import android.app.Application;

import java.util.concurrent.atomic.AtomicLong;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class Myapp extends Application {
    public static AtomicLong CorreoID= new AtomicLong();
    public static AtomicLong BorradorID= new AtomicLong();
    public static AtomicLong SalidaID= new AtomicLong();
    @Override
    public void onCreate() {
        super.onCreate();
        //Realm.init(this);
        initRealm();
        Realm realm=Realm.getDefaultInstance();
        CorreoID = getIdByTable(realm, CorreoDB.class);
        BorradorID = getIdByTable(realm, BorradorDB.class);
        SalidaID = getIdByTable(realm, CorreoSalida.class);
        realm.close();
    }

    private void initRealm() {

        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration= new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .allowWritesOnUiThread(true)
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private <T extends RealmObject> AtomicLong getIdByTable(Realm realm, Class<T>
            anyClass) {
        RealmResults<T> results=realm.where(anyClass).findAll();
        return (results.size()>0) ?new AtomicLong(results.max("id").intValue()):new AtomicLong(0);
    }

}
