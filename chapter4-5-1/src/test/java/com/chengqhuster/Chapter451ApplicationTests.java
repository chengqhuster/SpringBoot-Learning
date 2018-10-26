package com.chengqhuster;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.StringWriter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter451Application.class)
public class Chapter451ApplicationTests {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private VelocityEngine velocityEngine;

    @Test
    public void sendMail() throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("chengqhuster@163.com");
        message.setTo("chengqhuster@163.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        mailSender.send(message);
    }

    @Test
    public void sendAttachmentsMail() throws Exception {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("chengqhuster@163.com");
        helper.setTo("chengqhuster@163.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("jiegeng.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        mailSender.send(message);
    }

    @Test
    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("chengqhuster@163.com");
        helper.setTo("chengqhuster@163.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:jiegeng\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("jiegeng.jpg"));
//        addInline函数中资源名称需要与正文中cid:对应起来
        helper.addInline("jiegeng", file);

        mailSender.send(mimeMessage);
    }

    @Test
    public void sendTemplateMile() throws Exception {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("chengqhuster@163.com");
        helper.setTo("chengqhuster@163.com");
        helper.setSubject("主题：模板邮件");

        VelocityContext context = new VelocityContext();
        context.put("username", "Bruce Cheng");
        StringWriter writer = new StringWriter();
        velocityEngine.mergeTemplate("templates/mailTemplate.vm", "UTF-8", context, writer);
        helper.setText(writer.toString());
        mailSender.send(message);
    }
}
