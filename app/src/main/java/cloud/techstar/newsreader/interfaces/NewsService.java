package cloud.techstar.newsreader.interfaces;

import cloud.techstar.newsreader.models.WebSite;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Doljko on 3/22/2018.
 */

public interface NewsService {
    @GET("v2/top-headlines?country=us&category=business&apiKey=API_KEY")
    Call<WebSite> getSource();
}
