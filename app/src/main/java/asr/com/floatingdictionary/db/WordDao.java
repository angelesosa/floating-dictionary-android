package asr.com.floatingdictionary.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface WordDao {
    @Query("SELECT * FROM word WHERE word = :word LIMIT 1")
    Word findDirectorById(String word);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Word word);
}
