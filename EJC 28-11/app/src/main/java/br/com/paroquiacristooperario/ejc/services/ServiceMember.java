package br.com.paroquiacristooperario.ejc.services;

import br.com.paroquiacristooperario.ejc.model.Member;
import br.com.paroquiacristooperario.ejc.model.MemberList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceMember {
    @GET("encontristas")
    Call<MemberList> getMembers();

    @POST("encontristas")
    Call<Member> autenticar(@Body Member member);
}
