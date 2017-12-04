package br.com.paroquiacristooperario.ejc.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.paroquiacristooperario.ejc.R;
import br.com.paroquiacristooperario.ejc.model.Member;

public class AdapterMembers extends BaseAdapter{

    private List<Member> list;
    private Context context;

    public AdapterMembers(List<Member> l, Context c) {
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


        View view = inflater.inflate(R.layout.item_activity_member,null);

        Member m = list.get(position);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView sobrenome = (TextView) view.findViewById(R.id.sobrenome);
        TextView edicao = (TextView) view.findViewById(R.id.edicao);
        TextView data_nascimento = (TextView) view.findViewById(R.id.data_nascimento);

        nome.setText(m.getNome());
        sobrenome.setText(m.getSobrenome());
        edicao.setText(String.valueOf(m.getEdicao()) + "º");
        data_nascimento.setText(m.getData_nascimento());

        return view;
    }


}
