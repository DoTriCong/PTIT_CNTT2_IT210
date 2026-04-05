package org.example.ss1.model;

import org.example.ss1.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SystemConfig config = context.getBean(SystemConfig.class);

        System.out.println("Chi nhánh: " + config.getBranchName());
        System.out.println("Giờ mở cửa: " + config.getOpeningHour());
    }
}
