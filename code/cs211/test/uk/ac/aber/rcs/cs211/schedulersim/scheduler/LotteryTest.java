
package uk.ac.aber.rcs.cs211.schedulersim.scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.aber.rcs.cs211.schedulersim.Job;
import uk.ac.aber.rcs.cs211.schedulersim.SimulatorLoader;

/**
 * Test Class for the lottery algorithm.
 * Tests all methods inside the class, by creating a job queue and then adding, 
 * removing, resetting and looking for certain jobs.
 * @author craig
 */
public class LotteryTest {
    
    public LotteryTest() {
    }
  

    /**
     * Test of addNewJob method, of class Lottery.
     * Method creates a new set of jobs, and then tests theAddNewJob method to 
     * check if the correct job is added.
     */
    @Test
    public void testAddNewJob() throws Exception {
        System.out.println("addNewJob");
        Lottery instance = new Lottery();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        
        Job expResult = jobQueue.get(0);
        Job[] result = instance.getJobList();
        
        assertEquals(expResult, result[0]);
    }

    /**
     * Test of getNextJob method, of class Lottery.
     * Could not test this method due to the randomness of the algorithm, so knowing
     * what job would come next would be impossible.
     */
    @Test
    public void testGetNextJob() throws Exception {
        System.out.println("getNextJob");
    }

    /**
     * Test of returnJob method, of class Lottery.
     * Test checks if the jobs added in this example are the same when using the 
     * ReturnJob method. 
     */
    @Test
    public void testReturnJob() throws Exception {
        System.out.println("returnJob");
        Lottery instance = new Lottery();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        Job result = instance.getNextJob();
        Job expResult = jobQueue.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeJob method, of class Lottery.
     * Tests if when removing a job using the removeJOb method that the queue gets
     * shorter in size.
     */
    @Test
    public void testRemoveJob() throws Exception {
        System.out.println("removeJob");
        Lottery instance = new Lottery();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        instance.addNewJob(jobQueue.get(1));
        instance.removeJob(jobQueue.get(1));
        
        Job[] jobs =instance.getJobList();
        boolean result = true;
        if(jobs.length == 1){
            result = false;
        }
        
        boolean expResult = false;
        
        assertEquals(expResult, result);
    }

    /**
     * Test of reset method, of class Lottery.
     * Checks to see if the size of the queue turns to 0 after the Reset method 
     * is called to empty the queue.
     */
    @Test
    public void testReset() throws FileNotFoundException, IOException, SchedulerException {
        System.out.println("reset");
        Lottery instance = new Lottery();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        instance.addNewJob(jobQueue.get(1));
       
        instance.reset();
        int expResult = 0;
        int result = instance.getJobList().length;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getJobList method, of class Lottery.
     * Test checks if all the jobs added in this example are the same when using the 
     * ReturnJob method. 
     */
    @Test
    public void testGetJobList() throws FileNotFoundException, FileNotFoundException, SchedulerException, IOException {
       System.out.println("getJobList");
        Lottery instance = new Lottery();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        instance.addNewJob(jobQueue.get(1));
        
        Job[] expResult= new Job[2];
        expResult[0] = jobQueue.get(0);
        expResult[1] = jobQueue.get(1);
        Job[] result = instance.getJobList();
        assertArrayEquals(expResult, result);
    }
}