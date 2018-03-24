package cloud.techstar.newsreader.Common;

import cloud.techstar.newsreader.Interface.NewsService;
import cloud.techstar.newsreader.Remote.RetrofitClient;
import cloud.techstar.newsreader.Remote.IconBetterIdeaClient;

/**
 * Created by Doljko on 3/22/2018.
 */

public class Common {
    private static final String BASE_URL="https://newsapi.org/";

    public static final String API_KEY="5ed360f8134e41faa2eaee8b0aafd08b";

    public static NewsService getNewsService()
    {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService() {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }
}

