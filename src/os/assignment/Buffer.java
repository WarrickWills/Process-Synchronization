/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.assignment;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Warrick Wills - 13831575
 *         Kevin Wu - 13833453
 */
public class Buffer 
{

    // remember to initialize the semaphores in the constructor
    private Semaphore empty;
    private Semaphore full;
    private Semaphore mutex;
    //...
    private int[] buffer_item;
    private final int BUFFER_SIZE = 5;
    // Buffer Counter
    int i;
    // Input position
    int inPos;
    // Output position
    int outPos;

    public Buffer() 
    {
        // your code
        full = new Semaphore(0); // no elements
        mutex = new Semaphore(1); // mutually exclusive
        buffer_item = new int[BUFFER_SIZE];
        empty = new Semaphore(BUFFER_SIZE);
        i = 0;
        inPos = 0;
        outPos = 0;
    }

    public int insert_item(int item) 
    {
        try 
        {
            empty.acquire();
            mutex.acquire();
        } 
        catch (InterruptedException e) 
        {
            return -1;
        }
        
        if(i < BUFFER_SIZE) 
        {
            buffer_item[inPos] = item;
            i++;
            inPos = (inPos + 1) % BUFFER_SIZE; //Sets position to index
        }
        else return -1;

        mutex.release();
        full.release();
        
        return 0;
    }

    public int remove_item() 
    {
        int item;
        
        try
        {
            full.acquire();
            mutex.acquire();
        }
        catch (InterruptedException e)
        {
            return -1;
        }
        
        if(i > 0)
        {
            item = buffer_item[outPos];
            i--;
            outPos = (outPos + 1) % BUFFER_SIZE; //Sets position to index
        }
        else return -1;
        
        mutex.release();
	empty.release();
        
        return item;
    }
}
