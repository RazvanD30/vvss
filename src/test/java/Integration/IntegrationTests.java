package Integration;

import Domain.Nota;
import Domain.Student;
import Domain.Teme;
import Repository.NoteRepo;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Service.ServiceNote;
import Service.ServiceStudent;
import Service.ServiceTeme;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemeValidator;
import Validator.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import sun.security.validator.ValidatorException;

import java.util.Map;

import static junit.framework.TestCase.assertTrue;

@Category(IntegrationTests.class)
public class IntegrationTests {

        private StudentValidator vs;
        private TemeValidator vt;
        private NotaValidator vn;
        private StudentRepo strepo;
        private TemeRepo tmrepo;
        private NoteRepo ntrepo;
        private ServiceStudent stsrv;
        private ServiceTeme tmsrv;
        private ServiceNote ntsrv;


        @Before
        public void setData() {
            vs = new StudentValidator();
            vt= new TemeValidator();
            vn = new NotaValidator();
            strepo = new StudentRepo(vs,"StudentiXML.xml");
            tmrepo = new TemeRepo(vt,"TemaLaboratorXML.xml");
            ntrepo = new NoteRepo(vn);
            stsrv = new ServiceStudent(strepo);
            tmsrv = new ServiceTeme(tmrepo);
            ntsrv = new ServiceNote(ntrepo);
        }

        @Test
        public void addStudentTest() {

            Integer studentCountBeforeAdd = stsrv.rep.size();
            Integer newStudentsCount = 0;

            try{
                stsrv.add(new Student("9991","Nume", 935, "email@email.com", "Profesor"));
                newStudentsCount = stsrv.rep.size();
            }catch (ValidationException ex){
                assertTrue(false);
            }

            assertTrue(studentCountBeforeAdd < newStudentsCount);
        }

        @Test
        public void addHomeworkTest() {

            Integer temeBefore = tmsrv.rep.size();

            String descr;
            int id, saptLim,saptPred;

            id = 9990;
            descr = "alabala";
            saptLim = 12;
            saptPred = 12;
            Integer newCount = 0;

            tmsrv.add(new Teme(id, descr, saptLim, saptPred));
            newCount = tmsrv.rep.size();

            assertTrue(temeBefore < newCount);
        }

        @Test(expected = NullPointerException.class)
        public void addGradeTest() {
            Student student = new Student("9991","Nume", 935, "email@email.com", "Profesor");
            Teme tema = new Teme(9990, "descr", 12, 12);

            // ntsrv.add(new Nota(new Map.Entry<String,Integer>(), new Student("9991","Nume", 935, "email@email.com", "Profesor"), "1");
        }

        @Test
        public void testAll() {
            addStudentTest();
            addHomeworkTest();
            addGradeTest();
        }
}

