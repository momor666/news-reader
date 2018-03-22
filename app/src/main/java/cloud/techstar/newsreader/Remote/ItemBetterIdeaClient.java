package cloud.techstar.newsreader.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Doljko on 3/22/2018.
 */

public class ItemBetterIdeaClient {
    private static Retrofit retrofit=null;
    public static Retrofit getClient()
    {
        if(retrofit ==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.irishtimes.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
