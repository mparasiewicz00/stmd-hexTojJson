package pl.mpss.stmdhextojjson.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.mpss.stmdhextojjson.blockchain.Block;
import pl.mpss.stmdhextojjson.blockchain.BlockHeader;
import pl.mpss.stmdhextojjson.model.Frame;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

@Service
public class HexToJsonServiceImpl implements HexToJsonService {

    public String convert(byte[] bytes) throws JsonProcessingException {

        ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        BlockHeader blockHeader = new BlockHeader();
        blockHeader.setExmId(0); // !!!
        blockHeader.setIndex(buffer.getInt());
        blockHeader.setTimestamp(buffer.getLong());
        blockHeader.setDataLen(buffer.getLong());
        buffer.get(blockHeader.getPrevHash());
        buffer.get(blockHeader.getHash());

        Block block = new Block();
        block.setHeader(blockHeader);

        List<Frame> list = new ArrayList<>();

        while (buffer.remaining() > 5) {
            list.add(new Frame(buffer));
        }
        block.setData(list);

        return new ObjectMapper().writeValueAsString(block);
    }
}