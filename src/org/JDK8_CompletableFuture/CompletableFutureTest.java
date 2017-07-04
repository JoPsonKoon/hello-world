package org.JDK8_CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author jopson
 * @Description TODO () 
 */
public class CompletableFutureTest {
	public static void main(String[] args) {
		CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("enter into completableFuture()");
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("start to out of completableFuture()");
            return "a";
        });

        System.out.println("do something else");

        cf1.thenApply(v -> v + " b").thenAcceptAsync(v ->
                System.out.println(v)
        );
        
        System.out.println("finalize...");
	}
}
