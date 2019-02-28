package uniapply.com.daggerretrofit.Modeule;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import uniapply.com.daggerretrofit.Ui.MainActivity;
import uniapply.com.daggerretrofit.Qualifires.ActivityContext;
import uniapply.com.daggerretrofit.Scopes.ActivityScope;

@Module
public class MainActivityContextModule {

    private MainActivity mainActivity;
    public Context context;


    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.context=mainActivity;
    }
    @Provides
    @ActivityScope
    public MainActivity provideMainActivity(){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext(){
        return context;
    }

}
