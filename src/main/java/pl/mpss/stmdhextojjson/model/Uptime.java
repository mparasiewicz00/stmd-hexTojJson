package pl.mpss.stmdhextojjson.model;

import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;

@Setter
@Getter
public class Uptime {
    private long uptime;

    public Uptime(ByteBuffer buffer) {
        uptime = buffer.getInt();
    }

}