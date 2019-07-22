package droids.rizz.dagger2example;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SharedPrefModule.class})
public interface MyComponent {
    void inject(MainActivity activity);
    void inject(Main2Activity main2Activity);
}
