package br.com.paroquiacristooperario.ejc.services;

import br.com.paroquiacristooperario.ejc.model.MemberList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceMember {
    @GET("encontristas")
    Call<MemberList> getMembers();
}
