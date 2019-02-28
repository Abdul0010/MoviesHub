package uniapply.com.daggerretrofit.Modeule;

import dagger.Module;
import dagger.Provides;
import uniapply.com.daggerretrofit.Ui.MainActivity;
import uniapply.com.daggerretrofit.RecyclerViewAdapter;
import uniapply.com.daggerretrofit.Scopes.ActivityScope;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getList(RecyclerViewAdapter.ClickListener clickLister){
        return new RecyclerViewAdapter(clickLister);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getListener(MainActivity mainActivity){
        return mainActivity;
    }
}
