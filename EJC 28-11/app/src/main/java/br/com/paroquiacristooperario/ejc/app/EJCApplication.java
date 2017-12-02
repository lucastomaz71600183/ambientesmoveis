package br.com.paroquiacristooperario.ejc.app;

import android.app.Application;

import br.com.paroquiacristooperario.ejc.services.RestService;

public class EJCApplication extends Application{

    private static EJCApplication instance;

    private RestService service;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        service = new RestService("http://apiteste.fourtime.com/api/");
        service = new RestService("http://138.197.77.154:3005/");
    }

    public static EJCApplication getInstance() {
        return instance;
    }

    public RestService getRestService() {
        return service;
    }

}
