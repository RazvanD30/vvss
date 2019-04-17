package Repository;

import Domain.Nota;
import Domain.Student;
import Validator.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class NoteRepo extends AbstractRepo<Nota,Map.Entry<String,Integer>> {
    private DocumentBuilderFactory builderFactory;
    public NoteRepo(Validator<Nota> val){
        super(val);
        builderFactory=DocumentBuilderFactory.newInstance();
    }
    private void writeToFile(Nota s, String fd) throws IOException{

    }
    private void writeToFile2(Nota s) throws IOException{

    }
    public Nota save(Nota el,String fd) {
        AtomicInteger ok= new AtomicInteger();
        findAll().forEach(n->{ if(n.getStudent()==el.getStudent() && n.getTema()==el.getTema())  ok.set(1); });
        /**
         for(Nota n:findAll()){
         if(n.getStudent()==el.getStudent() && n.getTema()==el.getTema())
         ok=1;
         }
         */
        if(ok.get() ==0) {
            Nota t = super.save(el);
            try {
                if( false ) {
                    writeToFile(el, fd);
                    writeToFile2(el);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
            return t;
        }
        else {
            System.out.println("Nota deja existenta");
            return null;
        }
    }

}

