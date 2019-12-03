package asr.com.floatingdictionary.api;

import asr.com.floatingdictionary.db.Word;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataService {

    @GET("/cambridge/{Word}")
    Call<Word> getWord(
            @Path("Word") String wordString
    );
}
