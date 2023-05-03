package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;


import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        Integer idA = job1.getId();
        Integer idB = job2.getId();
        assertNotEquals(idA,idB);
    }
    @Test
    public void testTheFullConstructorSetAllFields() {
       Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       assertEquals("Product tester",job.getName());
       assertEquals("ACME", job.getEmployer().getValue());
       assertEquals("Desert", job.getLocation().getValue());
       assertEquals("Quality control",job.getPositionType().getValue());
       assertEquals("Persistence", job.getCoreCompetency().getValue());
       assertTrue(job.getName() instanceof String );
       assertTrue(job.getEmployer() instanceof Employer);
       assertTrue(job.getLocation() instanceof Location);
       assertTrue(job.getPositionType() instanceof PositionType);
       assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Integer id1 = job1.getId();
        Integer id2 = job2.getId();

        assertNotEquals(id1,id2);
    }

    @Test
    public void testToStringStartAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string = "ID: \n" + "Name: \n" + "Employer: \n" + "Location: \n" + "Position Type: \n" + "Core Competency: \n";

        assertEquals(string.charAt(0), job1.toString().charAt(0));

        assertEquals(string.length() -1, job1.toString().toString().length() - 1);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String string = "ID:" + job1.getId() + "\n" + "Name:" + job1.getName() + "\n" + "Employer:" + job1.getEmployer() + "\n" + "Location:" + job1.getLocation() + "\n" + "Position Type:" + job1.getPositionType() + "\n" + "Core Competency:" + job1.getCoreCompetency();
        assertEquals(string, job1.toString());
    }

}
