package uniapply.com.daggerretrofit;

import android.app.Activity;
import android.app.Application;

import uniapply.com.daggerretrofit.Component.ApplicationComponent;
import uniapply.com.daggerretrofit.Component.DaggerApplicationComponent;
import uniapply.com.daggerretrofit.Modeule.ContextModule;
import uniapply.com.daggerretrofit.Qualifires.ApplicationContext;

public class MyApplication extends Application {


    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent= DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);
    }
    public static MyApplication get(Activity activity){
        return (MyApplication)activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
