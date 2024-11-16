package com.boobalan.grokking.leetcode;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
//@DisplayName("Stress tests of both methods")
//public class StressTest {
//
//    private final static double INITIAL_AMOUNT = 10_000_000.;
//    private final static ExecutorService es = Executors.newFixedThreadPool(10);
//
//    @AfterAll
//    static void shutdownExecutorService() {
//        es.shutdown();
//    }
//
//    private static Stream<Arguments> provideArguments() {
//        return Stream.of(
//                Arguments.of(2, 100),
//                Arguments.of(2, 10000),
//                Arguments.of(10, 10000),
//                Arguments.of(100, 1000),
//                Arguments.of(500, 1000)
//        );
//    }
//
//    @ParameterizedTest(name = "Should perform all operations concurrently for {0} accounts and {1} operations")
//    @MethodSource("provideArguments")
//    @Timeout(value = 1, unit = TimeUnit.SECONDS)
//    public void shouldPerformAllOperationsConcurrently(int numberOfAccounts, int operations) throws InterruptedException {
//        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
//            double[] accounts = new double[numberOfAccounts];
//            Arrays.fill(accounts, INITIAL_AMOUNT);
//            BankingService bankingService = new BankingServiceImpl(accounts);
//
//            List<Callable<Void>> tasks = IntStream.range(0, numberOfAccounts).mapToObj(id ->
//                    Stream.concat(
//                            IntStream.range(0, operations).mapToObj(i -> new WithdrawTask(bankingService, id, 5)),
//                            IntStream.range(0, operations).mapToObj(i -> new DepositTask(bankingService, id, 4))
//                    )
//            ).flatMap(Function.identity()).collect(Collectors.toList());
//            Collections.shuffle(tasks);
//
//            es.invokeAll(tasks);
//
//            for (int id = 0; id < numberOfAccounts; id++) {
//                Assertions.assertEquals(INITIAL_AMOUNT - operations, bankingService.getBalance(id));
//            }
//        });
//    }
//
//    private static class WithdrawTask implements Callable<Void> {
//        private final BankingService bankingService;
//        private final int id;
//        private final double amount;
//
//        public WithdrawTask(BankingService bankingService, int id, double amount) {
//            this.bankingService = bankingService;
//            this.id = id;
//            this.amount = amount;
//        }
//
//        @Override
//        public Void call() throws InterruptedException {
//            bankingService.withdraw(id, amount);
//            return null;
//        }
//    }
//
//    private static class DepositTask implements Callable<Void> {
//        private final BankingService bankingService;
//        private final int id;
//        private final double amount;
//
//        public DepositTask(BankingService bankingService, int id, double amount) {
//            this.bankingService = bankingService;
//            this.id = id;
//            this.amount = amount;
//        }
//
//        @Override
//        public Void call() throws InterruptedException {
//            bankingService.deposit(id, amount);
//            return null;
//        }
//    }
//}