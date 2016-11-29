package org.experiment.lang.lora;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.experiment.util.builder.BuilderHelper;
import org.springframework.util.CollectionUtils;

import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Packets {

    private final List<Packet> packets;

    public Packets(List<Packet> packets) {
        this.packets = (CollectionUtils.isEmpty(packets)) ? null : BuilderHelper.copyList(packets);
    }
    public Packets() {
        this.packets = null;
    }

    public List<Packet> getPackets() {
        return packets;
    }
}
