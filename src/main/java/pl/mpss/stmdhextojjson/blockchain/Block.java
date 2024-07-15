package pl.mpss.stmdhextojjson.blockchain;

import lombok.Getter;
import lombok.Setter;
import pl.mpss.stmdhextojjson.model.Frame;

import java.util.List;

@Setter
@Getter
public class Block {
    private BlockHeader header;
    private List<Frame> data;

}