package org.experiment.lang.lora;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Packet {
    private String source;
    private String gw;
    private String time;
    private String ts;
    private String radio;
    private String mac;
    private String payload;
    private String decoded;
    private String who;
    private String count_invalid;
    private String mic_invalid;
    private String dup;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getGw() {
        return gw;
    }

    public void setGw(String gw) {
        this.gw = gw;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getDecoded() {
        return decoded;
    }

    public void setDecoded(String decoded) {
        this.decoded = decoded;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getCount_invalid() {
        return count_invalid;
    }

    public void setCount_invalid(String count_invalid) {
        this.count_invalid = count_invalid;
    }

    public String getMic_invalid() {
        return mic_invalid;
    }

    public void setMic_invalid(String mic_invalid) {
        this.mic_invalid = mic_invalid;
    }

    public String getDup() {
        return dup;
    }

    public void setDup(String dup) {
        this.dup = dup;
    }
}
