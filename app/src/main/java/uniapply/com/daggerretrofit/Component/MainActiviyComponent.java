package uniapply.com.daggerretrofit.Component;

import android.content.Context;

import dagger.Component;
import uniapply.com.daggerretrofit.Ui.MainActivity;
import uniapply.com.daggerretrofit.Modeule.AdapterModule;
import uniapply.com.daggerretrofit.Qualifires.ActivityContext;
import uniapply.com.daggerretrofit.Scopes.ActivityScope;

@ActivityScope
@Component(modules = AdapterModule.class,dependencies = ApplicationComponent.class)
public interface MainActiviyComponent {

    @ActivityContext
    Context getContext();

    void injectMainActivity(MainActivity mainActivity);
}
