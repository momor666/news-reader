package cloud.techstar.newsreader;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.florent37.diagonallayout.DiagonalLayout;

import cloud.techstar.newsreader.adapter.ListNewsAdapter;
import cloud.techstar.newsreader.common.Common;
import cloud.techstar.newsreader.interfaces.NewsService;
import dmax.dialog.SpotsDialog;

public class ListNews extends AppCompatActivity {

    KenBurnsView kbv;
    DiagonalLayout diagonalLayout;
    AlertDialog dialog;
    NewsService mServirse;
    TextView top_author, top_title;
    SwipeRefreshLayout swipeRefreshLayout;
    String source="", sortBy="", webHotURL="";
    ListNewsAdapter adapter;
    RecyclerView lstNews;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news2);

        mServirse = Common.getNewsService();
//        dialog = new SpotsDialog(this);
//        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
//        swipeRefreshLayout.setOnClickListener(new SwipeRefreshLayout.OnRefreshListener()
//        {
//            @Override
//            public void onRefresh(){
//                loadNews(source,true);
//            }
//        });
        diagonalLayout = (DiagonalLayout)findViewById(R.id.diagonalLayout);
        diagonalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        kbv = (KenBurnsView)findViewById(R.id.top_image);
        top_author = (TextView)findViewById(R.id.top_authoer);
        top_title = (TextView)findViewById(R.id.top_title);

        if(getIntent() != null)
        {
            source = getIntent().getStringExtra("source");
            sortBy = getIntent().getStringExtra("sortBy");
            if(!source.isEmpty() && !sortBy.isEmpty())
            {
                loadNews(source,false); 
            }
        }
    }

    private void loadNews(String source, boolean isRefreshed) {
        if(!isRefreshed)
        {
            dialog.show();
            mServirse.getNewestArticles();
            //26:25
        }
    }
}
