package com.example.SKB_DZ._dependency_injection;

import org.springframework.stereotype.Component;

import java.util.Locale;

//Не использовал нормальный логгер, потому что при вызове дестрой метода
//логгер не выводит сообщение
@Component
public class MyLogger {

    public void log(String level, String message) {
        System.out.printf("[%s] - [%s]%n", level.toUpperCase(Locale.ROOT), message);
    }
}
