package com.mortymaroon.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
        Camera camera = context.getBean("camera", CameraImpl.class);
        camera.breaking();
        camera.doPhotograph();
        camera = context.getBean("camera", CameraImpl.class);
        camera.doPhotograph();
        context.close();
    }
}
