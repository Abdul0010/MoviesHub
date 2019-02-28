package uniapply.com.daggerretrofit.Component;


import android.content.Context;

import dagger.Component;
import uniapply.com.daggerretrofit.Modeule.ContextModule;
import uniapply.com.daggerretrofit.Modeule.RetrofitModule;
import uniapply.com.daggerretrofit.MyApplication;
import uniapply.com.daggerretrofit.Qualifires.ApplicationContext;
import uniapply.com.daggerretrofit.Retrofit.ApiInterface;
import uniapply.com.daggerretrofit.Scopes.ApplicationScope;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {
    public ApiInterface getApiInterface();

    @ApplicationContext
    public Context getContext();
    public void injectApplication(MyApplication myApplication);
}
