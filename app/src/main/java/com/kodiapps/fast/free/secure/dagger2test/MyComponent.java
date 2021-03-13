package com.kodiapps.fast.free.secure.dagger2test;


import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {Sha_Modeule.class})
public interface MyComponent {
    void  inject(MainActivity activity);
}
