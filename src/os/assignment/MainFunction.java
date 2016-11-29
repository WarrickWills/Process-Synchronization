/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.assignment;

import java.util.Scanner;

/**
 *
 * @author Warrick Wills - 13831575
 *         Kevin Wu - 13833453
 */
public class MainFunction
{
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sleep time (im ms): ");
        int sleepTime = scanner.nextInt();
        System.out.println("Enter the amount of producers: ");
        int producers = scanner.nextInt();
        System.out.println("Enter the amount of consumers: ");
        int consumers = scanner.nextInt();
        long currentTime = System.currentTimeMillis();
        Buffer b = new Buffer();
        
        for(int i = 0; i < producers; i++)
            new Thread(new Producer(b)).start();

        for(int i = 0; i < consumers; i++)
            new Thread(new Consumer(b)).start();

        try
        {
            Thread.sleep(sleepTime);
        }
        catch(Exception ex)
        {
            System.out.println("Sleep Error");
        }
        
        System.out.println("Time consumed: " + (System.currentTimeMillis() - currentTime)/1000 + " seconds");
        System.exit(0);
    }
}
