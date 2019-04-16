package MaxPointsParticipantsMV;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import Domain.Student;
import Repository.StudentRepo;
import Service.ServiceStudent;
import Validator.StudentValidator;
import Validator.ValidationException;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    private ServiceStudent service;
    private Student student;

    @Before
    public void setup(){
        StudentRepo repo = new StudentRepo(new StudentValidator(),"C:\\Users\\Razvan\\Desktop\\SSVV\\LabAssiAsseProjectV04\\src\\studenti.xml");
        service = new ServiceStudent(repo);
        student = new Student("34","dorel",933,"dorel@cs.ubb","dorel");
    }


    @Test
    public void testAddUser__EC01__SUCCESS(){
        student.setNume("dorel");
        service.add(student);
    }

    @Test
    public void testAddUser__EC02__SUCCESS(){
        student.setNume("gigel");
        service.add(student);
    }

    @Test
    public void testAddUser__EC01__FAIL(){
        try {
            student.setNume("do2rel");
            service.add(student);
            fail();
        } catch (ValidationException e){

        }
    }

    @Test
    public void testAddUser__EC02__FAIL(){
        try {
            student.setNume("GYG3LBO$$");
            service.add(student);
            fail();
        } catch (ValidationException e){

        }
    }
}
