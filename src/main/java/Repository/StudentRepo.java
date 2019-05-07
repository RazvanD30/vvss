package Repository;

import Domain.Student;
import Validator.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

import static javax.xml.xpath.XPathFactory.newInstance;

public class StudentRepo extends AbstractRepo<Student, String> {
    private String fName;
    private DocumentBuilderFactory builderFactory;

    public StudentRepo(Validator<Student> val, String n) {
        super(val);
        this.fName = n;
        builderFactory = DocumentBuilderFactory.newInstance();
        if (!n.isEmpty())
            loadFromFile();
    }

    public void loadFromFile() {

    }

    private void writeToFile() {

    }

    @Override
    public Student save(Student el) {
        Student t = super.save(el);
        writeToFile();
        return t;
    }

    @Override
    public Student delete(String id) {
        Student t = super.delete(id);
        writeToFile();
        return t;
    }

    @Override
    public Student update(Student tt) {
        Student t = super.update(tt);
        writeToFile();
        return t;
    }

}
