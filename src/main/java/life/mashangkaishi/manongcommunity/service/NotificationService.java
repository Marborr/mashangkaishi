package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.dto.NotificationDTO;
import life.mashangkaishi.manongcommunity.dto.PageDTO;
import life.mashangkaishi.manongcommunity.dto.QuestionDTO;
import life.mashangkaishi.manongcommunity.enums.NotificationStatusEnum;
import life.mashangkaishi.manongcommunity.enums.NotificationTypeEnum;
import life.mashangkaishi.manongcommunity.exception.CustomizeErrorCode;
import life.mashangkaishi.manongcommunity.exception.CustomizeException;
import life.mashangkaishi.manongcommunity.mapper.NotificationMapper;
import life.mashangkaishi.manongcommunity.mapper.UserMapper;
import life.mashangkaishi.manongcommunity.model.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    @Autowired
    private NotificationMapper notificationMapper;

    public PageDTO list(Long id, Integer page, Integer size) {
        PageDTO<NotificationDTO> pageDTO=new PageDTO<>();

        Integer totalPage;
       NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria()
                .andReceiverEqualTo(id);
        Integer totalcount =(int) notificationMapper.countByExample(notificationExample);

        if (totalcount %size ==0){
            totalPage=totalcount /size;
        }else {
            totalPage=totalcount /size +1;
        }
        if (page<1){
            page=1;
        }
        if (page>totalPage){
            if (page<totalPage)
                page=totalPage;
        }
        pageDTO.setPageNumber(totalPage,page);

        Integer offset=size*(page-1);

        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andReceiverEqualTo(id);
        example.setOrderByClause("gmt_create desc");
        //example1等参数都是查询条件
        List<Notification> notifications = notificationMapper.selectByExampleWithRowbounds
                (example, new RowBounds(offset, size));
        if (notifications.size()==0){
            return pageDTO;
        }

        List<NotificationDTO> notificationDTOS=new ArrayList<>();

        for (Notification notification : notifications) {
            NotificationDTO notificationDTO = new NotificationDTO();
            BeanUtils.copyProperties(notification,notificationDTO);
            notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
            notificationDTOS.add(notificationDTO);
        }



        pageDTO.setData(notificationDTOS);
        return pageDTO;
    }

    public Long unreadCount(Long id) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria()
                .andReceiverEqualTo(id)
                .andStatusEqualTo(NotificationStatusEnum
                .UNREAD.getStatus());
       return notificationMapper.countByExample(notificationExample);
    }

    public NotificationDTO read(Long id, User user) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);
        if (notification==null){
            throw new CustomizeException(CustomizeErrorCode.NOTIFICATION_NOT_FOUND);
        }
        if (!Objects.equals(notification.getReceiver(),user.getId())){
            throw new CustomizeException(CustomizeErrorCode.READ_NOTIFICATION_FAIL);
        }
        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);

        NotificationDTO notificationDTO = new NotificationDTO();
        BeanUtils.copyProperties(notification,notificationDTO);
        notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
        return notificationDTO;
    }
}
