package br.com.aragy.singletonMultithread;

public class DemoMultiThread {
    public static void main(String[] args) {
        System.out.println("Se os valores são iguais, o singleton foi reusado (yay!)" + "\n" +
                "se os valores são dferentes, 2 singletons foram criados (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}
