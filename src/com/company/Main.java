package com.company;

public class Main {
    // Многопоточность - создание потока

    public static void main(String[] args) throws Exception {
	    MyThread myThread = new MyThread(); // Создает Поток - 0
	    myThread.start(); // запуск потока
        myThread.join(); // запускает выбранный поток до смерти

	    MyRun myRun = new MyRun();  // Создает конструктор Потока - 1
	    Thread thread = new Thread(myRun); // добавляет его в потоки
	    thread.start(); // запуск потока
	    Thread.yield(); // возможность запуска другого потока, но это не точно
        System.out.println("----Основной поток----");
        MyThread myThread1 = new MyThread(); // Создает Поток - 2
        myThread1.start(); // запуск потока

    }
}

class MyThread extends Thread { // создать поток при помощи extends
    public void run(){
        System.out.println(Thread.currentThread().getName()); // выводит имя потока
    }
}

class MyRun implements Runnable{ // создать поток при помощи implements
    public void run(){
        System.out.println(Thread.currentThread().getName()); // выводит имя потока
        try {
            Thread.sleep(100); // отправка потока в сон
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}