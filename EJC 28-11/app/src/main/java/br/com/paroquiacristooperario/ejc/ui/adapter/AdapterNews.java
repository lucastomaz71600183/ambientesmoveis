package br.com.paroquiacristooperario.ejc.ui.adapter;


import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.paroquiacristooperario.ejc.R;
import br.com.paroquiacristooperario.ejc.model.News;

public class AdapterNews extends BaseAdapter{

    private List<News> list;
    private Context context;

    public AdapterNews(List<News> l, Context c) {
        this.list = l;
        this.context = c;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_activity_home,null);

        News n = list.get(position);

        TextView titulo = (TextView) view.findViewById(R.id.titulo);
        TextView descricao = (TextView) view.findViewById(R.id.descricao);
        ImageView header = (ImageView) view.findViewById(R.id.header_img);
        FrameLayout informacoes = (FrameLayout) view.findViewById(R.id.informacoes);


        if(n.getImagem() == null) {
            informacoes.setVisibility(View.GONE);
        } else {
            informacoes.setVisibility(View.VISIBLE);
        }

        titulo.setText(n.getTitulo());
        descricao.setText(n.getDescricao());

        Glide.with(view).load(n.getImagem()).into(header);

        return view;
    }

}
