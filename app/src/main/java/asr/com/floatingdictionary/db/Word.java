package asr.com.floatingdictionary.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "word",
        indices = {@Index(value = "word", unique = true)})
public class Word {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "word")
    @NonNull
    @SerializedName("word")
    public String word;

    @ColumnInfo(name = "gra_cat")
    @NonNull
    @SerializedName("graCat")
    public String category;

    @ColumnInfo(name = "uk_pron_text")
    @SerializedName("uk_pron_text")
    @NonNull
    public String ukPronText;

    @ColumnInfo(name = "us_pron_text")
    @SerializedName("us_pron_text")
    @NonNull
    public String usPronText;

    @ColumnInfo(name = "uk_pron_audio_url")
    @SerializedName("uk_pron_audio_url")
    @NonNull
    public String ukPronAudioUrl;

    @ColumnInfo(name = "us_pron_audio_url")
    @SerializedName("us_pron_audio_url")
    @NonNull
    public String usPronAudioUrl;

    @ColumnInfo(name = "translate")
    @SerializedName("translate")
    @NonNull
    public String translate;

    public Word(int id, @NonNull String word, @NonNull String category, @NonNull String ukPronText, @NonNull String usPronText, @NonNull String ukPronAudioUrl, @NonNull String usPronAudioUrl, @NonNull String translate) {
        this.id = id;
        this.word = word;
        this.category = category;
        this.ukPronText = ukPronText;
        this.usPronText = usPronText;
        this.ukPronAudioUrl = ukPronAudioUrl;
        this.usPronAudioUrl = usPronAudioUrl;
        this.translate = translate;
    }
}
