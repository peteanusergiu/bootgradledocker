package org.experiment.lang.lora;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class LoraResponse {
    private String priv;
    private String op;
    private String ok;
    private String deveui;
//    private Packets packets;

    public LoraResponse(String priv, String op, String ok, String deveui) {
        this.priv = priv;
        this.op = op;
        this.ok = ok;
        this.deveui = deveui;
//        this.packets = packets;
    }

    public String getPriv() {
        return priv;
    }

    public void setPriv(String priv) {
        this.priv = priv;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public String getDeveui() {
        return deveui;
    }

    public void setDeveui(String deveui) {
        this.deveui = deveui;
    }

//    public Packets getPackets() {
//        return packets;
//    }
//
//    public void setPackets(Packets packets) {
//        this.packets = packets;
//    }


}
