package Repository;

import Domain.Teme;
import Domain.Teme;
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

public class TemeRepo extends AbstractRepo<Teme,Integer> {
    private String fName;
    private DocumentBuilderFactory builderFactory;
    public TemeRepo(Validator<Teme> val, String n){
        super(val);
        this.fName=n;
        builderFactory=DocumentBuilderFactory.newInstance();
        if(!n.isEmpty())
            loadFromFile();
    }
    public void loadFromFile(){

    }
    private void writeToFile(){

    }
    @Override
    public Teme save(Teme el) {
        Teme t= super.save(el);
        if(!this.fName.isEmpty())
            writeToFile();
        return t;
    }
    @Override
    public Teme delete(Integer id){
        Teme t=super.delete(id);
        writeToFile();
        return t;
    }
    @Override
    public Teme update(Teme tt){
        Teme t=super.update(tt);
        writeToFile();
        return t;
    }

}
