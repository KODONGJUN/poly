package kopo.poly.controller;


import kopo.poly.dto.MailDTO;
import kopo.poly.service.IMailService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class MailController {

    @Resource(name = "MailService")
    private IMailService mailService;


    @GetMapping(value = "Mail/mailForm")
    public String mailForm() throws Exception{
        return  "/Mail/mailForm";
    }

    @PostMapping(value = "Mail/sendMailResult")
    public String sendMail(HttpServletRequest request, ModelMap model) throws Exception {

        log.info(this.getClass().getName() + "mail.sendMail start");


        String toMail = CmmUtil.nvl(request.getParameter("toMail"));
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));


        MailDTO pDTO = new MailDTO();


        pDTO.setContents(contents);
        pDTO.setToMail(toMail);
        pDTO.setTitle(title);

        int res = mailService.doSendMail(pDTO);

        if( res == 1) {
            log.info(this.getClass().getName() + " mail.sendMail success");

        }else {
            log.info(this.getClass().getName() + " mail.sendMail fail");
        }

        model.addAttribute("res", String.valueOf(res));

        log.info(this.getClass().getName() + "mail.sendMail end");

        return "/Mail/sendMailResult";

    }
}
