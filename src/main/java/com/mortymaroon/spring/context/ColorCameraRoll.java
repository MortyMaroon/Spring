package com.mortymaroon.spring.context;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component()
@Primary
public class ColorCameraRoll implements CameraRoll {

    @Override
    public void processing() {
        System.out.println("-1 Color frame");
    }
}
