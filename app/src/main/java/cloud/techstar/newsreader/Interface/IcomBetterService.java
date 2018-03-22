package cloud.techstar.newsreader.Interface;

import cloud.techstar.newsreader.Model.IconBetterIdea;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Doljko on 3/22/2018.
 */

public interface IcomBetterService {
    @GET
    Call<IconBetterIdea> getIconUrl(@Url String url);
}
