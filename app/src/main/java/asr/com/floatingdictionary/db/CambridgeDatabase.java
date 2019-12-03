package asr.com.floatingdictionary.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * @author Antonina
 */
@Database(entities = {Word.class}, version = 2)
public abstract class CambridgeDatabase extends RoomDatabase {
    private static CambridgeDatabase INSTANCE;
    private static final String DB_NAME = "cambridge.db";

    public static CambridgeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CambridgeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CambridgeDatabase.class, DB_NAME)
                            .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Log.d("CambridgeDatabase", "populating with data...");
                                }
                            })
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    public void clearDb() {
    }

    public abstract WordDao wordDao();
}
