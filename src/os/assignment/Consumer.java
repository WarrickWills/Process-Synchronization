/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.assignment;

import java.util.Random;

/**
 *
 * @author Warrick Wills - 13831575
 *         Kevin Wu - 13833453
 */
public class Consumer implements Runnable 
{
        
    private Buffer buffer;
    private Random r;

    public Consumer(Buffer buffer)
    {
        this.buffer = buffer;
    }

    public void run()
    {
        r = new Random();
        
        while(true)
        {
            try
            {
                Thread.sleep(r.nextInt(1000));
            }
            catch(Exception ex)
            {
                System.out.println("Consumer failed to consume");
            }
            
            int consume = buffer.remove_item();
            if (consume == -1)
                System.out.println("Consumer failed to consume");
            else
                System.out.println("Consumer consumed " + consume);
        }
    }
}
