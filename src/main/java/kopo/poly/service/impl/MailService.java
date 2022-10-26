package kopo.poly.service.impl;

import kopo.poly.dto.MailDTO;
import kopo.poly.service.IMailService;
import kopo.poly.util.CmmUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.zip.ZipFile;


@Slf4j
@RequiredArgsConstructor
@Service("MailService")
public class MailService implements IMailService {

    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String fromMail;



    /*final String host = "smtp.naver.com";
    final String user = "klli1233@naver.com";
    final String password = "dlrlwk1!!";  */




    /*final String host = "smtp.naver.com";
    final String user = "klli1233@naver.com";
    final String password = "dlrlwk1!!";  */

    @Override
    public int doSendMail(MailDTO pDTO) {


        log.info(this.getClass().getName() + ".doSendMail start!");


        int res = 1;


        if (pDTO == null) {
            pDTO = new MailDTO();
        }

        String toMail = CmmUtil.nvl(pDTO.getToMail());
        String title = CmmUtil.nvl(pDTO.getTitle());
        String contents = CmmUtil.nvl(pDTO.getContents());

        log.info("toMail : " + toMail);
        log.info("title : " + title);
        log.info("contents : " + contents);


        /*String toMail = CmmUtil.nvl(pDTO.getToMail());

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");


        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);

            }

        }); */

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(message, "UTF-8");

        try {

            messageHelper.setTo(toMail);
            messageHelper.setFrom(fromMail);
            messageHelper.setSubject(title);
            messageHelper.setText(contents);

            mailSender.send(message);
        } catch (Exception e) {
            res = 0;
            log.info("[ERROR]" + this.getClass().getName() + ".doSendMail : " + e);
        }

        log.info(this.getClass().getName() + ".doSendMail end ");
        return res;

        /*try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));


            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));

            message.setSubject(CmmUtil.nvl(pDTO.getTitle()));

            message.setText(CmmUtil.nvl(pDTO.getContents()));

            Transport.send(message);
        }catch (MessagingException e) {
            res = 0;
            log.info("[ERROR] " + this.getClass().getName() + ".doSendMail : " + e);

        }catch (Exception e) {
            res = 0;
            log.info("[ERROR] " + this.getClass().getName() + ".doSendMail : " + e);

        }
         return res;       
    }*/

    }

    }
