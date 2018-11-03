package com.blue.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton//单例模式
@Named(value = "pianoJSR303Service")
public class PianoJSR303Service {

    @Inject
    private UserOPP userOPP;

    public void piano(){
        userOPP.isFFF("plano");
    }
}
