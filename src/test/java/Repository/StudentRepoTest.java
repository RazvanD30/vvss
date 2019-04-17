package Repository;

import Domain.Student;
import Domain.Teme;
import Validator.StudentValidator;
import Validator.TemeValidator;
import Validator.ValidationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StudentRepoTest {

    @Test
    public void testCase1(){
        assertValid(new Student(null,"Name",933,"email@email.com", "Professor"),false);
    }

    @Test
    public void testCase2(){
        assertValid(new Student("","Name",933,"email@email.com", "Professor"),false);
    }

    @Test
    public void testCase3(){
        assertValid(new Student("1","Name",933,"email@email.com", "Professor"),true);
    }

    @Test
    public void testCase4(){
        assertValid(new Student("1","Name",933, null, "Professor"),false);
    }

//    @Test
//    public void testCase5(){
//        assertValid(new Student(null,"Name",933,"email@email.com", "Professor"),true);
//    }
//
//    @Test
//    public void testCase6(){
//        assertValid(new int[]{0,2,-1},false);
//    }
//
//    @Test
//    public void testCase7(){
//        assertValid(new int[]{0,-1,1},false);
//    }
//
//    @Test
//    public void testCase8(){
//        assertValid(new int[]{0,-1,-1},false);
//    }


    private void assertValid(Student studentCandidate, boolean valid) {
        StudentRepo repo = new StudentRepo(new StudentValidator(),"");
        try{

            repo.save(studentCandidate);
            if(!valid) {
                fail("Expected invalid input.");
            } else {
                assertEquals(repo.size(),1);
            }
        } catch (ValidationException ex){
            if(valid){
                fail("Expected valid input.");
            } else {
                assertEquals(repo.size(),0);
            }
        }

    }
}
