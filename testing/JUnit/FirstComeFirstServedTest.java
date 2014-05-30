package uk.ac.aber.rcs.cs211.schedulersim.scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.aber.rcs.cs211.schedulersim.Job;
import uk.ac.aber.rcs.cs211.schedulersim.SimulatorLoader;

/**
 * Test Class for the first come first served algorithm.
 * Tests all methods inside the class, by creating a job queue and then adding, 
 * removing, resetting and looking for certain jobs.
 * @author craig
 */
public class FirstComeFirstServedTest {
    
    public FirstComeFirstServedTest() {
    }
    

    /**
     * Test of addNewJob method, of class FirstComeFirstServed.
     * Method creates a new set of jobs, and then tests theAddNewJob method to 
     * check if the correct job is added.
     */
    @Test
    public void testAddNewJob() throws Exception {
        System.out.println("addNewJob");
        FirstComeFirstServed instance = new FirstComeFirstServed();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        
        Job expResult = jobQueue.get(0);
        Job[] result = instance.getJobList();
        
        assertEquals(expResult, result[0]);
    }

    /**
     * Test of getNextJob method, of class FirstComeFirstServed.
     * This test checks to see if the correct job is returned after the algorithm
     * looks at which one should be given back at the head of the queue. Should be
     * the first one added that turns out to be one at the head of the queue.
     */
    @Test
    public void testGetNextJob() throws Exception {
        System.out.println("getNextJob");
        FirstComeFirstServed instance = new FirstComeFirstServed();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        Job result = instance.getNextJob();
        Job expResult = jobQueue.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnJob method, of class FirstComeFirstServed.
     * Test checks if the jobs added in this example are the same when using the 
     * ReturnJob method. 
     */
    @Test
    public void testReturnJob() throws Exception {
        System.out.println("returnJob");
        FirstComeFirstServed instance = new FirstComeFirstServed();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        Job result = instance.getNextJob();
        Job expResult = jobQueue.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeJob method, of class FirstComeFirstServed.
     * Tests if when removing a job using the removeJOb method that the queue gets
     * shorter in size.
     */
    @Test
    public void testRemoveJob() throws Exception {
        System.out.println("removeJob");
        FirstComeFirstServed instance = new FirstComeFirstServed();
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
     * Test of reset method, of class FirstComeFirstServed.
     * Checks to see if the size of the queue turns to 0 after the Reset method 
     * is called to empty the queue.
     */
    @Test
    public void testReset() throws FileNotFoundException, IOException, SchedulerException {
        System.out.println("reset");
        FirstComeFirstServed instance = new FirstComeFirstServed();
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
     * Test of getJobList method, of class FirstComeFirstServed.
     * Test checks if all the jobs added in this example are the same when using the 
     * ReturnJob method. 
     */
    @Test
    public void testGetJobList() throws FileNotFoundException, FileNotFoundException, SchedulerException, IOException {
        System.out.println("getJobList");
        FirstComeFirstServed instance = new FirstComeFirstServed();
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