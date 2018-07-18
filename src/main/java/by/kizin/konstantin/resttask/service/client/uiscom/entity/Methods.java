package by.kizin.konstantin.resttask.service.client.uiscom.entity;

public enum  Methods {

    LOGIN("login.user"),
    GET_SIP_LINE_VIRTUAL_NUMBERS("get.sip_line_virtual_numbers");

    private final String value;

    Methods(final String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
