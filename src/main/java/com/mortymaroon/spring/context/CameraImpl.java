package com.mortymaroon.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("camera")
@Scope("prototype")
public class CameraImpl implements Camera{
    @Autowired
    private CameraRoll cameraRoll;

    @Value("false")
    private boolean broken;

    @Override
    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    @Override
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    @Override
    public void breaking() {
        this.broken = true;
    }

    @Override
    public void doPhotograph() {
        if (isBroken()) {
            System.out.println("Camera is broken!");
            return;
        }
        System.out.println("Photo taken");
        cameraRoll.processing();
    }
}
