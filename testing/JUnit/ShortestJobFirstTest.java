
package uk.ac.aber.rcs.cs211.schedulersim.scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.aber.rcs.cs211.schedulersim.Job;
import uk.ac.aber.rcs.cs211.schedulersim.SimulatorLoader;

/**
 * Test Class for the shortest job first algorithm.
 * Tests all methods inside the class, by creating a job queue and then adding, 
 * removing, resetting and looking for certain jobs.
 * @author craig
 */
public class ShortestJobFirstTest {
    
    public ShortestJobFirstTest() {
    }
    
    /**
     * Test of addNewJob method, of class ShortestJobFirst.
     * Method creates a new set of jobs, and then tests theAddNewJob method to 
     * check if the correct job is added.
     */
    @Test
    public void testAddNewJob() throws Exception {
        System.out.println("addNewJob");
        ShortestJobFirst instance = new ShortestJobFirst();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        
        Job expResult = jobQueue.get(0);
        Job[] result = instance.getJobList();
        
        assertEquals(expResult, result[0]);
    }

    /**
     * Test of getNextJob method, of class ShortestJobFirst.
     * Test looks at the algorithm of choosing the shortest job next, by placing 
     * in three different length tasks in the wrong order and seeing if the shortest
     * comes out before the others.
     */
    @Test
    public void testGetNextJob() throws Exception {
        System.out.println("getNextJob");
        ShortestJobFirst instance = new ShortestJobFirst();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(2)); // has a length of 20
        instance.addNewJob(jobQueue.get(1)); //has a length of 12
        instance.addNewJob(jobQueue.get(0)); //has a length of 10
        
        Job result = instance.getNextJob();
        Job expResult = jobQueue.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnJob method, of class ShortestJobFirst.
     * Test checks if the jobs added in this example are the same when using the 
     * ReturnJob method. 
     */
    @Test
    public void testReturnJob() throws Exception {
        System.out.println("returnJob");
        ShortestJobFirst instance = new ShortestJobFirst();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        Job result = instance.getNextJob();
        Job expResult = jobQueue.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeJob method, of class ShortestJobFirst.
     * Tests if when removing a job using the removeJOb method that the queue gets
     * shorter in size.
     */
    @Test
    public void testRemoveJob() throws Exception {
        System.out.println("removeJob");
        ShortestJobFirst instance = new ShortestJobFirst();
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
     * Test of reset method, of class ShortestJobFirst.
     * Checks to see if the size of the queue turns to 0 after the Reset method 
     * is called to empty the queue.
     */
    @Test
    public void testReset() throws SchedulerException, FileNotFoundException, IOException {
        System.out.println("reset");
        ShortestJobFirst instance = new ShortestJobFirst();
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
     * Test of getJobList method, of class ShortestJobFirst.
     * Test checks if all the jobs added in this example are the same when using the 
     * ReturnJob method. 
     */
    @Test
    public void testGetJobList() throws SchedulerException, FileNotFoundException, IOException {
        System.out.println("getJobList");
        ShortestJobFirst instance = new ShortestJobFirst();
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