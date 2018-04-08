package cloud.techstar.newsreader.common;

import cloud.techstar.newsreader.interfaces.IconBetterIdeaService;
import cloud.techstar.newsreader.interfaces.NewsService;
import cloud.techstar.newsreader.remote.RetrofitClient;
import cloud.techstar.newsreader.remote.IconBetterIdeaClient;

/**
 * Created by Doljko on 3/22/2018.
 */

public class Common {
    private static final String BASE_URL= "https://newsapi.org/";

    public static final String API_KEY = "5ed360f8134e41faa2eaee8b0aafd08b";

    public static NewsService getNewsService()
    {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService() {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }

    //https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=a7072d9c2ad9495a8dd5cb58a7fd30df
    public static String getAPIUrl(String source,String sortBy,String apiKEY)
    {
        StringBuilder apiUrl = new StringBuilder("https://newsapi.org/v2/top-headlines?sources=");
        return apiUrl.append(source)
                .append("&apiKey=")
                .append(apiKEY)
                .toString();
    }
}

