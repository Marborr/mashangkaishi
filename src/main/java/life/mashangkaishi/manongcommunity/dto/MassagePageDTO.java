package life.mashangkaishi.manongcommunity.dto;

import life.mashangkaishi.manongcommunity.model.systemMessage;
import lombok.Data;

import java.util.List;

@Data
public class MassagePageDTO {
    List<systemMessage> messages;
    int MegPages;
}
