package droids.rizz.dagger2example;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/*
    @Module : This is used on the class that does the work of constructing objects that’ll be eventually provided as dependencies.
    @Provides : This is used on the methods inside the Module class that’ll return the object.
    @Inject : This is used upon a constructor, field or a method and indicates that dependency has been requested.
    @Component : The Module class doesn’t provide the dependency directly to the class that’s requesting it. For this, a Component interface is used that acts as a bridge between @Module and @Inject.
    @Singleton : This indicates that only a single instance of the dependency object would be created.
*/


@Module
class SharedPrefModule {
    private Context context;

    SharedPrefModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Context provideContex() {
        return context;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharePrefrances(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
