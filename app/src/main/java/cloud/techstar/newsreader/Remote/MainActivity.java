package cloud.techstar.newsreader.Remote;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import cloud.techstar.newsreader.Adapter.ListSourceAdapter;
import cloud.techstar.newsreader.Common.Common;
import cloud.techstar.newsreader.Interface.NewsService;
import cloud.techstar.newsreader.Model.WebSite;
import cloud.techstar.newsreader.R;
import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Doljko on 3/22/2018.
 */

public class MainActivity extends AppCompatActivity {

    RecyclerView listWebsite;
    RecyclerView.LayoutManager layoutManager;
    NewsService mService;
    ListSourceAdapter adapter;
    AlertDialog dialog;

    @Override

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Paper.init(this);
        mService = Common.getNewsService();
        listWebsite = (RecyclerView) findViewById(R.id.list_source);
        layoutManager = new LinearLayoutManager(this);
        listWebsite.setLayoutManager(layoutManager);

        dialog = new SpotsDialog(this);

        loadWebsiteSource(false);
    }

    private void loadWebsiteSource(boolean isRefreshed){

        if(!isRefreshed)
        {
            String cache = Paper.book().read("cache");
            if(cache != null && !cache.isEmpty())
            {
                WebSite webSite = new Gson().fromJson(cache,WebSite.class);
                adapter = new ListSourceAdapter(getBaseContext(),webSite);
                adapter.notifyDataSetChanged();
                listWebsite.setAdapter(adapter);
            }
            else{
                dialog.show();
                mService.getSource().enqueue(new Callback<WebSite>() {
                    @Override
                    public void onResponse(Call<WebSite> call, Response<WebSite> response) {
                        adapter = new ListSourceAdapter(getBaseContext(),response.body());
                        adapter.notifyDataSetChanged();
                        listWebsite.setAdapter(adapter);

                        Paper.book().write("cache", new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<WebSite> call, Throwable t) {

                    }
                });
            }
        }
    }
}
