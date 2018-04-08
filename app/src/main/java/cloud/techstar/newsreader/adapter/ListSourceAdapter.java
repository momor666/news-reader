package cloud.techstar.newsreader.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cloud.techstar.newsreader.ListNews;
import cloud.techstar.newsreader.common.Common;
import cloud.techstar.newsreader.interfaces.IconBetterIdeaService;
import cloud.techstar.newsreader.interfaces.ItemClickListener;
import cloud.techstar.newsreader.models.WebSite;
import cloud.techstar.newsreader.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Doljko on 3/22/2018.
 */

class ListSourceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    ItemClickListener itemClickListener;

    TextView source_title;
    CircleImageView source_image;

    public ListSourceViewHolder(View itemView) {
        super(itemView);
        source_image=(CircleImageView) itemView.findViewById(R.id.source_image);
        source_title=(TextView) itemView.findViewById(R.id.source_name);
        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;

    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
public class ListSourceAdapter extends RecyclerView.Adapter<ListSourceViewHolder>{
    private Context context;
    private WebSite webSite;

    private IconBetterIdeaService mService;

    public ListSourceAdapter(Context context, WebSite webSite) {
        this.context = context;
        this.webSite = webSite;

        mService = Common.getIconService();
    }

    @Override
    public ListSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.source_layout,parent,false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListSourceViewHolder holder, int position) {



        holder.source_title.setText(webSite.getSources().get(position).getName());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, ListNews.class);
                intent.putExtra("source", webSite.getSources().get(position).getId());
//                intent.putExtra("sortBy", webSite.getSources().get(position).getSortBysAvailable().get(0));
                //get method sortbyavailable
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return webSite.getSources().size();
    }
}