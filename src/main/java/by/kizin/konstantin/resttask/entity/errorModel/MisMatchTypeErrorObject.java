package by.kizin.konstantin.resttask.entity.errorModel;

public class MisMatchTypeErrorObject extends SubError {

    private String debugMessage;

    private String issueValue;

    private String reqType;

    public MisMatchTypeErrorObject(String issueValue,String reqType) {
        this.issueValue = issueValue;
        this.reqType = reqType;
        this.debugMessage = "Can't convert '"+issueValue+"' into "+reqType;
    }

    public String getIssueValue() {
        return issueValue;
    }

    public void setIssueValue(String issueValue) {
        this.issueValue = issueValue;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MisMatchTypeErrorObject that = (MisMatchTypeErrorObject) o;

        if (debugMessage != null ? !debugMessage.equals(that.debugMessage) : that.debugMessage != null) return false;
        if (issueValue != null ? !issueValue.equals(that.issueValue) : that.issueValue != null) return false;
        return reqType != null ? reqType.equals(that.reqType) : that.reqType == null;
    }

    @Override
    public int hashCode() {
        int result = debugMessage != null ? debugMessage.hashCode() : 0;
        result = 31 * result + (issueValue != null ? issueValue.hashCode() : 0);
        result = 31 * result + (reqType != null ? reqType.hashCode() : 0);
        return result;
    }
}
