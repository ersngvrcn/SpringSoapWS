package xxtg.oracle.apps.xxtgtest;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "SecondService")
public class SecondService {
    /* Returns String */
    @WebMethod(operationName = "SecondServiceMethod1")
    public String method1(){
        int a = 1;
        Integer b = null;
        String c = b.toString();
        return "hello SecondServiceMethod1";
    }
    
}
