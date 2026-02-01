package com.automationteststore.core;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class AllureAttachments {

    public static void attachPng(String name, byte[] png) {
        Allure.addAttachment(name, "image/png", new ByteArrayInputStream(png), ".png");
    }
}
