package dev.ghlima.demokafka.demo2;

public class ConsumerGroups {

    private static class Consumer1{
        public static void main(String[] args) {
            Consumer.start("1");
        }
    }

    private static class Consumer2{
        public static void main(String[] args) {
            Consumer.start("2");
        }
    }

    private static class Consumer3{
        public static void main(String[] args) {
            Consumer.start("3");
        }
    }
}
