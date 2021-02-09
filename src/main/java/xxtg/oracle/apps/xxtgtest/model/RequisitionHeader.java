package xxtg.oracle.apps.xxtgtest.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"requisitionHeaderId","segment1","description","authorizationStatus","wfItemKey"})
public class RequisitionHeader {
    private int requisitionHeaderId;
    private String segment1;
    private String description;
    private String authorizationStatus;
    private String wfItemKey;

    public int getRequisitionHeaderId() {
        return requisitionHeaderId;
    }

    public void setRequisitionHeaderId(int requisitionHeaderId) {
        this.requisitionHeaderId = requisitionHeaderId;
    }

    public String getSegment1() {
        return segment1;
    }

    public void setSegment1(String segment1) {
        this.segment1 = segment1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorizationStatus() {
        return authorizationStatus;
    }

    public void setAuthorizationStatus(String authorizationStatus) {
        this.authorizationStatus = authorizationStatus;
    }

    public String getWfItemKey() {
        return wfItemKey;
    }

    public void setWfItemKey(String wfItemKey) {
        this.wfItemKey = wfItemKey;
    }
}
