package cloud.techstar.newsreader.interfaces;

import cloud.techstar.newsreader.common.Common;
import cloud.techstar.newsreader.models.News;
import cloud.techstar.newsreader.models.WebSite;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Doljko on 3/22/2018.
 */

public interface NewsService {
    @GET("v2/sources?language=en&apiKey="+ Common.API_KEY)
    Call<WebSite> getSources();

    @GET

    Call<News> getNewestArticles(@Url String url);
}
