package uk.ac.aber.rcs.cs211.schedulersim.scheduler;

import java.util.*;
import uk.ac.aber.rcs.cs211.schedulersim.*;

/**
 * A Shortest Job First/ shortest time remaining algorithm.
 * This will check for the shortest time remaining of all the processes and return 
 * these on each run of the class.
 * @author crh13
 * @see uk.ac.aber.rcs.cs211.schedulersim.Simulator
 *
 */
public class ShortestJobFirst implements Scheduler {

	protected ArrayList<Job> queue;
	private int numberOfJobs;
	
	public ShortestJobFirst () {
		this.queue = new ArrayList<Job>();
		this.numberOfJobs=0;
	}
        
	/**
	 * Add a new job onto the queue at the relevant position.
	 * This job must not already exist on the queue.
	 * @param job The new process job to be added.
	 * @throws SchedulerException if the job already exists on the queue.
	 */
	public void addNewJob(Job job) throws SchedulerException {
		if (this.queue.contains(job)) throw new SchedulerException("Job already on Queue");
		this.queue.add(this.numberOfJobs, job);
		this.numberOfJobs++;
	}

	/**
	 * Returns the next job at the head of the ready queue.
	 * Loops through the job queue to find out the job with the least time remaining, 
         * by deducting the length of a job with the amount complete. 
         * @return lastJobReturned
         * @throws SchedulerException 
	 */
	public Job getNextJob() throws SchedulerException {
		Job lastJobReturned;
		if (this.numberOfJobs<1) throw new SchedulerException("Empty Queue");
                int timeRemaining;
                timeRemaining = this.queue.get(0).getLength() - this.queue.get(0).getProgramCounter();
                lastJobReturned = (Job)this.queue.get(0);
                for(int i=0; i <this.queue.size(); i++ )
                {
                    if(timeRemaining > this.queue.get(i).getLength() - this.queue.get(i).getProgramCounter()){
                          timeRemaining = this.queue.get(i).getLength() - this.queue.get(i).getProgramCounter();
                          lastJobReturned = (Job)this.queue.get(i);
                      }
                    
                }
		return lastJobReturned;
	}
        
        /**
	 * A job has had some processing done, and is now being returned to the queue.
	 * This is where a job should be moved from the front of the queue to the
	 * new position it should be occupying.
	 * @param job A job pre-existing on the queue, being returned.
	 * @throws SchedulerException if the job does not exist on the queue.
	 */
	public void returnJob(Job job) throws SchedulerException {
		if (!this.queue.contains(job)) throw new SchedulerException("Job not on Queue");
		// nothing to do in this implementation.
	}
        
        /**
	 * Remove the Job from the queue.
	 * This may be because the job has finished, or because it has become blocked
	 * waiting for I/O
	 * @param job the job to remove.
	 * @throws SchedulerException if the job does not exist on the queue.
	 */
	public void removeJob(Job job) throws SchedulerException {
		if (!this.queue.contains(job)) throw new SchedulerException("Job not on Queue");
		this.queue.remove(job);
		this.numberOfJobs--;
	}
        
        /**
	 * Clear the internal data structures. 
	 *
	 */
	public void reset() {
		this.queue.clear();
		this.numberOfJobs=0;
	}
        
	/**
	 * Get a list of the jobs currently on the queue in order.
	 * @return An array of jobs in order they are on the queue.
	 */
	public Job[] getJobList() {
		Job[] jobs = new Job[queue.size()];
		for (int i=0; i<queue.size(); i++) {
			jobs[i]=this.queue.get(i);
		}
		return jobs;
	}

}