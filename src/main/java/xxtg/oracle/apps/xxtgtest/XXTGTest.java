package xxtg.oracle.apps.xxtgtest;

import xxtg.oracle.apps.xxtgtest.model.RequisitionHeader;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebService(serviceName = "XXTGTestService")
public class XXTGTest {

    @WebMethod(operationName = "method1")
    public String method1() throws Exception {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String returnMessage = "SUCCESSFUL";
        ResultSet resultSet = null;
        String query = "SELECT segment1,\n" +
                       "       description,\n" +
                       "       authorization_status,\n" +
                       "       wf_item_key\n" +
                       "  FROM apps.po_requisition_headers_all\n" +
                       " WHERE requisition_header_id = 2527767";
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("ONE_STF_DATA_SOURCE");
            conn = dataSource.getConnection();
            preparedStatement = conn.prepareCall(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                returnMessage = resultSet.getString("SEGMENT1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            returnMessage = e.getMessage();
        } catch (Exception ex){
            ex.printStackTrace();
            returnMessage = ex.getMessage();
        } finally {
            preparedStatement.close();
            conn.close();
        }
        return returnMessage;
    }
    @WebMethod(operationName = "method2")
    public RequisitionHeader method2(@WebParam(name = "requisitionHeaderId") int headerId) throws Exception {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String returnMessage = "SUCCESSFUL";
        RequisitionHeader requisitionHeader = null;
        ResultSet resultSet = null;
        String query = "SELECT segment1,\n" +
                "       description,\n" +
                "       authorization_status,\n" +
                "       wf_item_key\n" +
                "  FROM apps.po_requisition_headers_all\n" +
                " WHERE requisition_header_id = ?";
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("ONE_STF_DATA_SOURCE");
            conn = dataSource.getConnection();
            preparedStatement = conn.prepareCall(query);
            preparedStatement.setInt(1,headerId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                requisitionHeader = new RequisitionHeader();
                requisitionHeader.setRequisitionHeaderId(headerId);
                requisitionHeader.setSegment1(resultSet.getString("SEGMENT1"));
                requisitionHeader.setAuthorizationStatus(resultSet.getString("AUTHORIZATION_STATUS"));
                requisitionHeader.setDescription(resultSet.getString("DESCRIPTION"));
                requisitionHeader.setWfItemKey(resultSet.getString("WF_ITEM_KEY"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            returnMessage = e.getMessage();
        } catch (Exception ex){
            ex.printStackTrace();
            returnMessage = ex.getMessage();
        } finally {
            preparedStatement.close();
            conn.close();
        }
        return requisitionHeader;
    }
}
