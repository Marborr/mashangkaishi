package life.mashangkaishi.manongcommunity.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class SendMail {
    @Autowired
    private JavaMailSender mailSender;

    public int send(String mailAddress,int code){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom("749286375@qq.com");
        //接收者
        mainMessage.setTo(mailAddress);
        //发送的标题
        mainMessage.setSubject("码上开始：验证码");
        //发送的内容
        mainMessage.setText(String.valueOf(code));
        try {
            mailSender.send(mainMessage);
            System.out.println("测试邮件已发送。");

        } catch (Exception e) {

            System.out.println("测试邮件发送邮件时发生异常了！"+e);
        }
        mailSender.send(mainMessage);
        return 1;
    }
}
