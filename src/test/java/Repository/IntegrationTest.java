package Repository;

import Domain.Nota;
import Domain.Student;
import Domain.Teme;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemeValidator;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.Assert.*;

public class IntegrationTest {

    private StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"");
    private TemeRepo temeRepo = new TemeRepo(new TemeValidator(),"");
    private NoteRepo noteRepo = new NoteRepo(new NotaValidator());


    @Test
    public void incrementalIntegration()  {
        addStudent();
        addTema();
        addNota();
    }


    @Test
    public void addStudent(){
        studentRepo = new StudentRepo(new StudentValidator(),"");
        Student st = new Student("1","dorel",933,"dorel@scs.ubbcluj.ro","dorel");
        int before = studentRepo.size();
        studentRepo.save(st);
        int after = studentRepo.size();
        assertEquals(before+1,after);
    }

    @Test
    public void addTema(){
        Teme teme = new Teme(2,"desc",2,4);
        int before = temeRepo.size();
        temeRepo.save(teme);
        int after = temeRepo.size();
        assertEquals(before+1,after);
    }

    @Test
    public void integration(){

        studentRepo = new StudentRepo(new StudentValidator(),"");
        Student st = new Student("1","dorel",933,"dorel@scs.ubbcluj.ro","dorel");
        int before1 = studentRepo.size();
        studentRepo.save(st);
        int after1 = studentRepo.size();
        assertEquals(before1+1,after1);

        Teme teme = new Teme(2,"desc",2,4);
        int before2 = temeRepo.size();
        temeRepo.save(teme);
        int after2 = temeRepo.size();
        assertEquals(before2+1,after2);

        Map.Entry<String, Integer> nid = new AbstractMap.SimpleEntry<String, Integer>("1", 1);
        Nota nota = new Nota(nid,studentRepo.findOne("1"),temeRepo.findOne(2),5,5);
        int before3 = noteRepo.size();
        noteRepo.save(nota);
        int after3 = noteRepo.size();
        assertEquals(before3+1,after3);
    }

    @Test
    public void addNota(){
        try {
            Map.Entry<String, Integer> nid = new AbstractMap.SimpleEntry<String, Integer>("1", 1);
            Nota nota = new Nota(nid, null, null, 5, 5);
            int before = noteRepo.size();
            noteRepo.save(nota);
            int after = noteRepo.size();
            fail();
        }catch (NullPointerException e){

        }
    }

}
