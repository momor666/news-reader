package cloud.techstar.newsreader.Common;

import cloud.techstar.newsreader.Interface.NewsService;
import cloud.techstar.newsreader.Model.IconBetterIdea;
import cloud.techstar.newsreader.Remote.RetrofitCliet;
import retrofit2.Retrofit;

/**
 * Created by Doljko on 3/22/2018.
 */

public class Common {
    private static final String BASE_URL="https://newsapi.org/";

    public static final String API_KEY="5ed360f8134e41faa2eaee8b0aafd08b";

    public static NewsService getNewsService() {
        {
            return RetrofitCliet.getClient(BASE_URL).create(NewsService.class);
        }

    public static IconBetterIdeaService getIconService() {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }
}
}
