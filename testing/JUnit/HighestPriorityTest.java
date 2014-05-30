
package uk.ac.aber.rcs.cs211.schedulersim.scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.ac.aber.rcs.cs211.schedulersim.Job;
import uk.ac.aber.rcs.cs211.schedulersim.SimulatorLoader;

/**
 * Test Class for the highest priority algorithm.
 * Tests all methods inside the class, by creating a job queue and then adding, 
 * removing, resetting and looking for certain jobs.
 * @author craig
 */
public class HighestPriorityTest {
    
    public HighestPriorityTest() {
    }

    /**
     * Test of addNewJob method, of class HighestPriority.
     * Method creates a new set of jobs, and then tests theAddNewJob method to 
     * check if the correct job is added.
     */
    @Test
    public void testAddNewJob() throws Exception {
        System.out.println("addNewJob");
        HighestPriority instance = new HighestPriority();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        
        Job expResult = jobQueue.get(0);
        Job[] result = instance.getJobList();
        
        assertEquals(expResult, result[0]);
    }

    /**
     * Test of getNextJob method, of class HighestPriority.
     * This test checks to see if the correct job is returned after the algorithm
     * looks at which has the highest priority task. Tested by adding in wrong order
     * and seeing if correct higher priority task is chosen.
     */
    @Test
    public void testGetNextJob() throws Exception {
        System.out.println("getNextJob");
        HighestPriority instance = new HighestPriority();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(1));//has a priority of 2
        instance.addNewJob(jobQueue.get(0)); //has a priority of 1
        
        Job result = instance.getNextJob();
        Job expResult = jobQueue.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnJob method, of class HighestPriority.
     * Test checks if the jobs added in this example are the same when using the 
     * ReturnJob method. 
     */
    @Test
    public void testReturnJob() throws Exception {
        System.out.println("returnJob");
        HighestPriority instance = new HighestPriority();
        ArrayList<Job> jobQueue;
        jobQueue = SimulatorLoader.Load("a.jobs");
        instance.addNewJob(jobQueue.get(0));
        Job result = instance.getNextJob();
        Job expResult = jobQueue.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeJob method, of class HighestPriority.
     * Tests if when removing a job using the removeJOb method that the queue gets
     * shorter in size.
     */
    @Test
    public void testRemoveJob() throws Exception {
        System.out.println("removeJob");
        HighestPriority instance = new HighestPriority();
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
     * Test of reset method, of class HighestPriority.
     * Checks to see if the size of the queue turns to 0 after the Reset method 
     * is called to empty the queue.
     */
    @Test
    public void testReset() throws FileNotFoundException, IOException, SchedulerException {
        System.out.println("reset");
        HighestPriority instance = new HighestPriority();
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
     * Test of getJobList method, of class HighestPriority.
     * Test checks if all the jobs added in this example are the same when using the 
     * ReturnJob method. 
     */
    @Test
    public void testGetJobList() throws FileNotFoundException, IOException, IOException, SchedulerException {
        System.out.println("getJobList");
        HighestPriority instance = new HighestPriority();
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