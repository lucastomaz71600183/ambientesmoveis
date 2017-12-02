package br.com.paroquiacristooperario.ejc.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MemberList {

    public void setList(List<Member> list) {
        this.list = list;
    }

    @SerializedName("lista")
    private List<Member> list;

    public List<Member> getList() { return list; }

}
