package ru.intensive.week05;

import java.util.logging.Logger;

/**
 *Параметры -XX:+PrintGCDateStamps, -Xloggc:Tools/gc.log считаются устаревшими
 * после 9 java используются параметры: -Xlog:gc*:<путь к файлу>:time -XX:+PrintGCDetails
 */
public class GarbageCollectorExample {
    private static Logger LOGGER = Logger.getLogger(GarbageCollectorExample.class.getName());

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        while (true) {
            Object obj = new Object();
            // создаем объект и сразу же удаляем ссылку на него
            obj = null;

            if (System.currentTimeMillis() - startTime > 1000) { // запускаем GC каждую секунду
                System.gc();
                LOGGER.info("Garbage collector was triggered.");
                startTime = System.currentTimeMillis(); // обновляем время последнего запуска GC
            }

            Thread.sleep(10); // ждем некоторое время перед созданием следующего объекта
        }
    }
}