package br.com.paroquiacristooperario.ejc.model;
import com.google.gson.annotations.SerializedName;
import java.util.List;



public class NewsList {

    public void setList(List<News> list) {
        this.list = list;
    }

    @SerializedName("result")
    private List<News> list;

    public List<News> getList() { return list; }
}
