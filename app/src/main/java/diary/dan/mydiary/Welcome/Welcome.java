package diary.dan.mydiary.Welcome;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import diary.dan.mydiary.R;
import diary.dan.mydiary.model.DataModel;

public class Welcome extends  RecyclerView.Adapter<Welcome.Myholder> {

    List<DataModel> dataModelArrayList;

    public Welcome(List<DataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView title,content,date;

        public Myholder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.item_title);
            content = (TextView) itemView.findViewById(R.id.item_content);
            date = (TextView) itemView.findViewById(R.id.item_date);
        }
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,null);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        DataModel dataModel=dataModelArrayList.get(position);
        holder.title.setText(dataModel.getTitle());
        holder.content.setText(dataModel.getContent());

        //Convert seconds from epoch unix time to actual date
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM d, yyyy HH:mm");
        String dateString = formatter.format(new Date(dataModel.getDate() * 1000L));
        holder.date.setText(dateString);

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}
