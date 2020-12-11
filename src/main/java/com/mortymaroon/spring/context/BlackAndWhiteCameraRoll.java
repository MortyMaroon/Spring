package com.mortymaroon.spring.context;

import org.springframework.stereotype.Component;

@Component()
public class BlackAndWhiteCameraRoll implements CameraRoll {

    @Override
    public void processing() {
        System.out.println("-1 Black and white frame");
    }
}
