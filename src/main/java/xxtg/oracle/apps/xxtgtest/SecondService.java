package xxtg.oracle.apps.xxtgtest;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "SecondService")
public class SecondService {

    @WebMethod(operationName = "SecondServiceMethod1")
    public String method1(){
        int a = 1;
        String b = null;
        b.toString();
        return "hello SecondServiceMethod1";
    }
    
}
