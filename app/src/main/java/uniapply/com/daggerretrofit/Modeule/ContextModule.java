package uniapply.com.daggerretrofit.Modeule;

import android.content.Context;

import java.security.PublicKey;

import dagger.Module;
import dagger.Provides;
import uniapply.com.daggerretrofit.Qualifires.ApplicationContext;
import uniapply.com.daggerretrofit.Scopes.ApplicationScope;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext(){
        return context;
    }
}
