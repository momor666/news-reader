package cloud.techstar.newsreader.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cloud.techstar.newsreader.Interface.ItemClickListener;
import cloud.techstar.newsreader.Model.WebSite;
import cloud.techstar.newsreader.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Doljko on 3/22/2018.
 */

class ListSourceViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener
{
    ItemClickListener itemClickListener;

    TextView source_title;
    CircleImageView source_image;

     public ListSourceViewHolder(View itemView) {
         super(itemView);

         source_image=(CircleImageView) itemView.findViewById(R.id.source_image);
         source_title=(TextView) itemView.findViewById(R.id.source_name);
     }

    public ListSourceViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);
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

        public ListSourceAdapter(Context baseContext, WebSite webSite) {
        }


        @Override
    public ListSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.sourse_layout, parent,false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListSourceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return webSite.getSources().size();
    }
}
