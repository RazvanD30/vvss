package Repository;

import Domain.Teme;
import Validator.TemeValidator;
import Validator.ValidationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TemeRepoTest {

    @Test
    public void testCase1(){
        assertValid(new int[]{1,2,1},true);
    }

    @Test
    public void testCase2(){
        assertValid(new int[]{1,2,-1},false);
    }

    @Test
    public void testCase3(){
        assertValid(new int[]{1,-1,1},false);
    }

    @Test
    public void testCase4(){
        assertValid(new int[]{1,-1,-1},false);
    }

    @Test
    public void testCase5(){
        assertValid(new int[]{0,2,1},false);
    }

    @Test
    public void testCase6(){
        assertValid(new int[]{0,2,-1},false);
    }

    @Test
    public void testCase7(){
        assertValid(new int[]{0,-1,1},false);
    }

    @Test
    public void testCase8(){
        assertValid(new int[]{0,-1,-1},false);
    }


    private void assertValid(int[] testCaseInput, boolean valid) {
        TemeRepo repo = new TemeRepo(new TemeValidator(),"");
        try{
            Teme teme = new Teme(testCaseInput[0],"not_relevant",testCaseInput[2],testCaseInput[1]);
            repo.save(teme);
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