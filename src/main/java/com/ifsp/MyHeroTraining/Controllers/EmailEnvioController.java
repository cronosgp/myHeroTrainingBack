package com.ifsp.MyHeroTraining.Controllers;

import com.ifsp.MyHeroTraining.ConfigEmail.EmailConfig;
import com.ifsp.MyHeroTraining.DTO.CadastroUsuarioDto;
import com.ifsp.MyHeroTraining.DTO.EmailDto;
import com.ifsp.MyHeroTraining.Forms.EmailForms;
import com.ifsp.MyHeroTraining.Models.CadastroUsuario;
import com.ifsp.MyHeroTraining.Models.EmailUsuario;
import com.ifsp.MyHeroTraining.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.mail.internet.MimeMessage;
import javax.swing.text.html.HTML;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.mail.javamail.JavaMailSender;
@RestController
@RequestMapping("/email")
public class EmailEnvioController {
    @Autowired
    private EmailRepository emailRepository;
        @GetMapping
        public List<EmailUsuario> listaUsuario(){
        List<EmailUsuario> emailUsuarios = emailRepository.findAll();
        return emailUsuarios;
    }
    @PostMapping
    public ResponseEntity enviaEmail(@RequestBody String emailusuario) {
        JavaMailSender mailSender;
        EmailConfig em = new EmailConfig();
        mailSender = em.mailSender();
       // emailRepository.save(emailUsuario);
        try{
        	MimeMessage mime = mailSender.createMimeMessage();
        	  MimeMessageHelper helper = new MimeMessageHelper(mime, true);
        	  helper.setFrom("myherotraining@gmail.com");
        	  helper.setTo(emailusuario);
        	  helper.setSubject("Cadastro MyHeroTraining");
        	  String htmlText = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" + 
        	  		"<html xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" + 
        	  		"\n" + 
        	  		"<head>\n" + 
        	  		"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" + 
        	  		"    <meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0;\" />\n" + 
        	  		"    <!--[if !mso]--><!-- -->\n" + 
        	  		"    <link href='https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,600,700' rel=\"stylesheet\">\n" + 
        	  		"    <link href='https://fonts.googleapis.com/css?family=Quicksand:300,400,700' rel=\"stylesheet\">\n" + 
        	  		"    <!--<![endif]-->\n" + 
        	  		"\n" + 
        	  		"    <title>Myhero Training</title>\n" + 
        	  		"\n" + 
        	  		"    <style type=\"text/css\">\n" + 
        	  		"        body {\n" + 
        	  		"            width: 100%;\n" + 
        	  		"            background-color: #ffffff;\n" + 
        	  		"            margin: 0;\n" + 
        	  		"            padding: 0;\n" + 
        	  		"            -webkit-font-smoothing: antialiased;\n" + 
        	  		"            mso-margin-top-alt: 0px;\n" + 
        	  		"            mso-margin-bottom-alt: 0px;\n" + 
        	  		"            mso-padding-alt: 0px 0px 0px 0px;\n" + 
        	  		"        }\n" + 
        	  		"\n" + 
        	  		"        p,\n" + 
        	  		"        h1,\n" + 
        	  		"        h2,\n" + 
        	  		"        h3,\n" + 
        	  		"        h4 {\n" + 
        	  		"            margin-top: 0;\n" + 
        	  		"            margin-bottom: 0;\n" + 
        	  		"            padding-top: 0;\n" + 
        	  		"            padding-bottom: 0;\n" + 
        	  		"        }\n" + 
        	  		"\n" + 
        	  		"        span.preheader {\n" + 
        	  		"            display: none;\n" + 
        	  		"            font-size: 1px;\n" + 
        	  		"        }\n" + 
        	  		"\n" + 
        	  		"        html {\n" + 
        	  		"            width: 100%;\n" + 
        	  		"        }\n" + 
        	  		"\n" + 
        	  		"        table {\n" + 
        	  		"            font-size: 14px;\n" + 
        	  		"            border: 0;\n" + 
        	  		"        }\n" + 
        	  		"        /* ----------- responsivity ----------- */\n" + 
        	  		"\n" + 
        	  		"        @media only screen and (max-width: 640px) {\n" + 
        	  		"            /*------ top header ------ */\n" + 
        	  		"            .main-header {\n" + 
        	  		"                font-size: 20px !important;\n" + 
        	  		"            }\n" + 
        	  		"            .main-section-header {\n" + 
        	  		"                font-size: 28px !important;\n" + 
        	  		"            }\n" + 
        	  		"            .show {\n" + 
        	  		"                display: block !important;\n" + 
        	  		"            }\n" + 
        	  		"            .hide {\n" + 
        	  		"                display: none !important;\n" + 
        	  		"            }\n" + 
        	  		"            .align-center {\n" + 
        	  		"                text-align: center !important;\n" + 
        	  		"            }\n" + 
        	  		"            .no-bg {\n" + 
        	  		"                background: none !important;\n" + 
        	  		"            }\n" + 
        	  		"            /*----- main image -------*/\n" + 
        	  		"            .main-image img {\n" + 
        	  		"                width: 440px !important;\n" + 
        	  		"                height: auto !important;\n" + 
        	  		"            }\n" + 
        	  		"            /* ====== divider ====== */\n" + 
        	  		"            .divider img {\n" + 
        	  		"                width: 440px !important;\n" + 
        	  		"            }\n" + 
        	  		"            /*-------- container --------*/\n" + 
        	  		"            .container590 {\n" + 
        	  		"                width: 440px !important;\n" + 
        	  		"            }\n" + 
        	  		"            .container580 {\n" + 
        	  		"                width: 400px !important;\n" + 
        	  		"            }\n" + 
        	  		"            .main-button {\n" + 
        	  		"                width: 220px !important;\n" + 
        	  		"            }\n" + 
        	  		"            /*-------- secions ----------*/\n" + 
        	  		"            .section-img img {\n" + 
        	  		"                width: 320px !important;\n" + 
        	  		"                height: auto !important;\n" + 
        	  		"            }\n" + 
        	  		"            .team-img img {\n" + 
        	  		"                width: 100% !important;\n" + 
        	  		"                height: auto !important;\n" + 
        	  		"            }\n" + 
        	  		"        }\n" + 
        	  		"\n" + 
        	  		"        @media only screen and (max-width: 479px) {\n" + 
        	  		"            /*------ top header ------ */\n" + 
        	  		"            .main-header {\n" + 
        	  		"                font-size: 18px !important;\n" + 
        	  		"            }\n" + 
        	  		"            .main-section-header {\n" + 
        	  		"                font-size: 26px !important;\n" + 
        	  		"            }\n" + 
        	  		"            /* ====== divider ====== */\n" + 
        	  		"            .divider img {\n" + 
        	  		"                width: 280px !important;\n" + 
        	  		"            }\n" + 
        	  		"            /*-------- container --------*/\n" + 
        	  		"            .container590 {\n" + 
        	  		"                width: 280px !important;\n" + 
        	  		"            }\n" + 
        	  		"            .container590 {\n" + 
        	  		"                width: 280px !important;\n" + 
        	  		"            }\n" + 
        	  		"            .container580 {\n" + 
        	  		"                width: 260px !important;\n" + 
        	  		"            }\n" + 
        	  		"            /*-------- secions ----------*/\n" + 
        	  		"            .section-img img {\n" + 
        	  		"                width: 280px !important;\n" + 
        	  		"                height: auto !important;\n" + 
        	  		"            }\n" + 
        	  		"        }\n" + 
        	  		"    </style>\n" + 
        	  		"    <!--[if gte mso 9]><style type=”text/css”>\n" + 
        	  		"        body {\n" + 
        	  		"        font-family: arial, sans-serif!important;\n" + 
        	  		"        }\n" + 
        	  		"        </style>\n" + 
        	  		"    <![endif]-->\n" + 
        	  		"</head>\n" + 
        	  		"\n" + 
        	  		"\n" + 
        	  		"<body class=\"respond\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n" + 
        	  		"    <!-- pre-header -->\n" + 
        	  		"    <table style=\"display:none!important;\">\n" + 
        	  		"        <tr>\n" + 
        	  		"            <td>\n" + 
        	  		"                <div style=\"overflow:hidden;display:none;font-size:1px;color:#ffffff;line-height:1px;font-family:Arial;maxheight:0px;max-width:0px;opacity:0;\">\n" + 
        	  		"                   Que bom que resolveu treinar com a gente, Seja muito bem vindo!\n" + 
        	  		"                </div>\n" + 
        	  		"            </td>\n" + 
        	  		"        </tr>\n" + 
        	  		"    </table>\n" + 
        	  		"    <!-- pre-header end -->\n" + 
        	  		"    <!-- header -->\n" + 
        	  		"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\">\n" + 
        	  		"\n" + 
        	  		"        <tr>\n" + 
        	  		"            <td align=\"center\">\n" + 
        	  		"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td align=\"center\">\n" + 
        	  		"\n" + 
        	  		"                            <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" + 
        	  		"\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td align=\"center\" height=\"70\" style=\"height:70px;\">\n" + 
        	  		"									  <a href=\"\"  style=\"color: #312c32; text-decoration: none;font-size: 25px;\"><strong>MyHeroTraining</strong></a>\n" + 
        	  		"                                     \n" + 
        	  		"                                </tr>\n" + 
        	  		"\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td align=\"center\">\n" + 
        	  		"                                        <table width=\"360 \" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" + 
        	  		"                                            class=\"container590 hide\">\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td width=\"120\" align=\"center\" style=\"font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\n" + 
        	  		"                                                    <a href=\"\" style=\"color: #312c32; text-decoration: none;\">Sobre o MyheroTraining</a>\n" + 
        	  		"                                                </td>\n" + 
        	  		"                                                <td width=\"120\" align=\"center\" style=\"font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\n" + 
        	  		"                                                    <a href=\"\" style=\"color: #312c32; text-decoration: none;\">Exercícíos</a>\n" + 
        	  		"                                                </td>\n" + 
        	  		"                                                \n" + 
        	  		"                                            </tr>\n" + 
        	  		"                                        </table>\n" + 
        	  		"                                    </td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"                            </table>\n" + 
        	  		"                        </td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                </table>\n" + 
        	  		"            </td>\n" + 
        	  		"        </tr>\n" + 
        	  		"    </table>\n" + 
        	  		"    <!-- end header -->\n" + 
        	  		"\n" + 
        	  		"    <!-- big image section -->\n" + 
        	  		"\n" + 
        	  		"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\" class=\"bg_color\">\n" + 
        	  		"\n" + 
        	  		"        <tr>\n" + 
        	  		"            <td align=\"center\">\n" + 
        	  		"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td align=\"center\" style=\"color: #343434; font-size: 24px; font-family: Quicksand, Calibri, sans-serif; font-weight:700;letter-spacing: 3px; line-height: 35px;\"\n" + 
        	  		"                            class=\"main-header\">\n" + 
        	  		"                            <!-- section text ======-->\n" + 
        	  		"\n" + 
        	  		"                            <div style=\"line-height: 35px\">\n" + 
        	  		"\n" + 
        	  		"                                Que bom que você resolver treinar com a gente, seja muito <span style=\"color: #5caad2;\">Bem Vindo !</span>\n" + 
        	  		"\n" + 
        	  		"                            </div>\n" + 
        	  		"                        </td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td align=\"center\">\n" + 
        	  		"                            <table border=\"0\" width=\"40\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"eeeeee\">\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td height=\"2\" style=\"font-size: 2px; line-height: 2px;\">&nbsp;</td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"                            </table>\n" + 
        	  		"                        </td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td height=\"20\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td align=\"left\">\n" + 
        	  		"                            <table border=\"0\" width=\"590\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td align=\"left\" style=\"color: #888888; font-size: 16px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\n" + 
        	  		"                                        <!-- section text ======-->\n" + 
        	  		"\n" + 
        	  		"                                        <p style=\"line-height: 24px; margin-bottom:15px;\">\n" + 
        	  		"\n" + 
        	  		"                                            Olá,\n" + 
        	  		"\n" + 
        	  		"                                        </p>\n" + 
        	  		"                                        <p style=\"line-height: 24px;margin-bottom:15px;\">\n" + 
        	  		"                                           Ótima Notícia, seu cadastrado já foi validado.\n" + 
        	  		"                                        </p>\n" + 
        	  		"                                        <p style=\"line-height: 24px; margin-bottom:20px;\">\n" + 
        	  		"                                         Acesse sua conta\n" + 
        	  		"                                        </p>\n" + 
        	  		"                                        <table border=\"0\" align=\"center\" width=\"180\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"5caad2\" style=\"margin-bottom:20px;\">\n" + 
        	  		"\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td align=\"center\" style=\"color: #ffffff; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 22px; letter-spacing: 2px;\">\n" + 
        	  		"                                                    <!-- main section button -->\n" + 
        	  		"\n" + 
        	  		"                                                    <div style=\"line-height: 22px;\">\n" + 
        	  		"                                                        <a href=\"https://myhtraining.herokuapp.com/\" style=\"color: #ffffff; text-decoration: none;\">Minha Conta</a>\n" + 
        	  		"                                                    </div>\n" + 
        	  		"                                                </td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"\n" + 
        	  		"                                        </table>\n" + 
        	  		"                                        <p style=\"line-height: 24px\">\n" + 
        	  		"                                            Atenciosamente,</br>\n" + 
        	  		"                                           MyHeroTraining\n" + 
        	  		"                                        </p>\n" + 
        	  		"\n" + 
        	  		"                                    </td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"                            </table>\n" + 
        	  		"                        </td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"\n" + 
        	  		"\n" + 
        	  		"\n" + 
        	  		"\n" + 
        	  		"                </table>\n" + 
        	  		"\n" + 
        	  		"            </td>\n" + 
        	  		"        </tr>\n" + 
        	  		"\n" + 
        	  		"        <tr>\n" + 
        	  		"            <td height=\"40\" style=\"font-size: 40px; line-height: 40px;\">&nbsp;</td>\n" + 
        	  		"        </tr>\n" + 
        	  		"\n" + 
        	  		"    </table>\n" + 
        	  		"\n" + 
        	  		"    <!-- end section -->\n" + 
        	  		"\n" + 
        	  		"\n" + 
        	  		"    <!-- main section -->\n" + 
        	  		"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"2a2e36\">\n" + 
        	  		"\n" + 
        	  		"        <tr>\n" + 
        	  		"          \n" + 
        	  		"\n" + 
        	  		"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td height=\"50\" style=\"font-size: 50px; line-height: 50px;\">&nbsp;</td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td align=\"center\">\n" + 
        	  		"                            <table border=\"0\" width=\"380\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" + 
        	  		"                                class=\"container590\">\n" + 
        	  		"\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td align=\"center\">\n" + 
        	  		"                                        <table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"container580\">\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td align=\"center\" style=\"color: #cccccc; font-size: 16px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 26px;\">\n" + 
        	  		"                                                    <!-- section text ======-->\n" + 
        	  		"\n" + 
        	  		"                                                    <div style=\"line-height: 26px\">\n" + 
        	  		"\n" + 
        	  		"                                                       \n" + 
        	  		"                                                    </div>\n" + 
        	  		"                                                </td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"                                        </table>\n" + 
        	  		"                                    </td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"\n" + 
        	  		"                            </table>\n" + 
        	  		"                        </td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td align=\"center\">\n" + 
        	  		"                            <table border=\"0\" align=\"center\" width=\"250\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:2px solid #ffffff;\">\n" + 
        	  		"\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td align=\"center\" style=\"color: #ffffff; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 22px; letter-spacing: 2px;\">\n" + 
        	  		"                                        <!-- main section button -->\n" + 
        	  		"\n" + 
        	  		"                                        <div style=\"line-height: 22px;\">\n" + 
        	  		"                                            <a href=\"\" style=\"color: #fff; text-decoration: none;\">VIEW THE COLLECTION</a>\n" + 
        	  		"                                        </div>\n" + 
        	  		"                                    </td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td height=\"10\" style=\"font-size: 10px; line-height: 10px;\">&nbsp;</td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"\n" + 
        	  		"                            </table>\n" + 
        	  		"                        </td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td height=\"50\" style=\"font-size: 50px; line-height: 50px;\">&nbsp;</td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                </table>\n" + 
        	  		"            </td>\n" + 
        	  		"        </tr>\n" + 
        	  		"\n" + 
        	  		"    </table>\n" + 
        	  		"\n" + 
        	  		"    <!-- end section -->\n" + 
        	  		"\n" + 
        	  		"    <!-- contact section -->\n" + 
        	  		"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"ffffff\" class=\"bg_color\">\n" + 
        	  		"\n" + 
        	  		"        <tr>\n" + 
        	  		"            <td height=\"60\" style=\"font-size: 60px; line-height: 60px;\">&nbsp;</td>\n" + 
        	  		"        </tr>\n" + 
        	  		"\n" + 
        	  		"        <tr>\n" + 
        	  		"            <td align=\"center\">\n" + 
        	  		"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590 bg_color\">\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td align=\"center\">\n" + 
        	  		"                            <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590 bg_color\">\n" + 
        	  		"\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td>\n" + 
        	  		"                                        <table border=\"0\" width=\"300\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" + 
        	  		"                                            class=\"container590\">\n" + 
        	  		"\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <!-- logo -->\n" + 
        	  		"                                                <td align=\"left\">\n" + 
        	  		"                                                    <a href=\"\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"80\" border=\"0\" style=\"display: block; width: 80px;\" src=\"https://mdbootstrap.com/img/logo/mdb-email.png\" alt=\"\" /></a>\n" + 
        	  		"                                                </td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td align=\"left\" style=\"color: #888888; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 23px;\"\n" + 
        	  		"                                                    class=\"text_color\">\n" + 
        	  		"                                                    <div style=\"color: #333333; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; font-weight: 600; mso-line-height-rule: exactly; line-height: 23px;\">\n" + 
        	  		"\n" + 
        	  		"                                                        Email us: <br/> <a href=\"mailto:\" style=\"color: #888888; font-size: 14px; font-family: 'Hind Siliguri', Calibri, Sans-serif; font-weight: 400;\">contact@mdbootstrap.com</a>\n" + 
        	  		"\n" + 
        	  		"                                                    </div>\n" + 
        	  		"                                                </td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"\n" + 
        	  		"                                        </table>\n" + 
        	  		"\n" + 
        	  		"                                        <table border=\"0\" width=\"2\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" + 
        	  		"                                            class=\"container590\">\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td width=\"2\" height=\"10\" style=\"font-size: 10px; line-height: 10px;\"></td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"                                        </table>\n" + 
        	  		"\n" + 
        	  		"                                        <table border=\"0\" width=\"200\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" + 
        	  		"                                            class=\"container590\">\n" + 
        	  		"\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td class=\"hide\" height=\"45\" style=\"font-size: 45px; line-height: 45px;\">&nbsp;</td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"\n" + 
        	  		"\n" + 
        	  		"\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td height=\"15\" style=\"font-size: 15px; line-height: 15px;\">&nbsp;</td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td>\n" + 
        	  		"                                                    <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\">\n" + 
        	  		"                                                        <tr>\n" + 
        	  		"                                                            <td>\n" + 
        	  		"                                                                <a href=\"https://www.facebook.com/mdbootstrap\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"24\" border=\"0\" style=\"display: block;\" src=\"http://i.imgur.com/Qc3zTxn.png\" alt=\"\"></a>\n" + 
        	  		"                                                            </td>\n" + 
        	  		"                                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n" + 
        	  		"                                                            <td>\n" + 
        	  		"                                                                <a href=\"https://twitter.com/MDBootstrap\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"24\" border=\"0\" style=\"display: block;\" src=\"http://i.imgur.com/RBRORq1.png\" alt=\"\"></a>\n" + 
        	  		"                                                            </td>\n" + 
        	  		"                                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\n" + 
        	  		"                                                            <td>\n" + 
        	  		"                                                                <a href=\"https://plus.google.com/u/0/b/107863090883699620484/107863090883699620484/posts\" style=\"display: block; border-style: none !important; border: 0 !important;\"><img width=\"24\" border=\"0\" style=\"display: block;\" src=\"http://i.imgur.com/Wji3af6.png\" alt=\"\"></a>\n" + 
        	  		"                                                            </td>\n" + 
        	  		"                                                        </tr>\n" + 
        	  		"                                                    </table>\n" + 
        	  		"                                                </td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"\n" + 
        	  		"                                        </table>\n" + 
        	  		"                                    </td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"                            </table>\n" + 
        	  		"                        </td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"                </table>\n" + 
        	  		"            </td>\n" + 
        	  		"        </tr>\n" + 
        	  		"\n" + 
        	  		"        <tr>\n" + 
        	  		"            <td height=\"60\" style=\"font-size: 60px; line-height: 60px;\">&nbsp;</td>\n" + 
        	  		"        </tr>\n" + 
        	  		"\n" + 
        	  		"    </table>\n" + 
        	  		"    <!-- end section -->\n" + 
        	  		"\n" + 
        	  		"    <!-- footer ====== -->\n" + 
        	  		"    <table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"f4f4f4\">\n" + 
        	  		"\n" + 
        	  		"        <tr>\n" + 
        	  		"            <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" + 
        	  		"        </tr>\n" + 
        	  		"\n" + 
        	  		"        <tr>\n" + 
        	  		"            <td align=\"center\">\n" + 
        	  		"\n" + 
        	  		"                <table border=\"0\" align=\"center\" width=\"590\" cellpadding=\"0\" cellspacing=\"0\" class=\"container590\">\n" + 
        	  		"\n" + 
        	  		"                    <tr>\n" + 
        	  		"                        <td>\n" + 
        	  		"                            <table border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" + 
        	  		"                                class=\"container590\">\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td align=\"left\" style=\"color: #aaaaaa; font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;\">\n" + 
        	  		"                                        <div style=\"line-height: 24px;\">\n" + 
        	  		"\n" + 
        	  		"                                            <span style=\"color: #333333;\">Material Design for Bootstrap</span>\n" + 
        	  		"\n" + 
        	  		"                                        </div>\n" + 
        	  		"                                    </td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"                            </table>\n" + 
        	  		"\n" + 
        	  		"                            <table border=\"0\" align=\"left\" width=\"5\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" + 
        	  		"                                class=\"container590\">\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td height=\"20\" width=\"5\" style=\"font-size: 20px; line-height: 20px;\">&nbsp;</td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"                            </table>\n" + 
        	  		"\n" + 
        	  		"                            <table border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;\"\n" + 
        	  		"                                class=\"container590\">\n" + 
        	  		"\n" + 
        	  		"                                <tr>\n" + 
        	  		"                                    <td align=\"center\">\n" + 
        	  		"                                        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" + 
        	  		"                                            <tr>\n" + 
        	  		"                                                <td align=\"center\">\n" + 
        	  		"                                                    <a style=\"font-size: 14px; font-family: 'Work Sans', Calibri, sans-serif; line-height: 24px;color: #5caad2; text-decoration: none;font-weight:bold;\"\n" + 
        	  		"                                                        href=\"{{UnsubscribeURL}}\">UNSUBSCRIBE</a>\n" + 
        	  		"                                                </td>\n" + 
        	  		"                                            </tr>\n" + 
        	  		"                                        </table>\n" + 
        	  		"                                    </td>\n" + 
        	  		"                                </tr>\n" + 
        	  		"\n" + 
        	  		"                            </table>\n" + 
        	  		"                        </td>\n" + 
        	  		"                    </tr>\n" + 
        	  		"\n" + 
        	  		"                </table>\n" + 
        	  		"            </td>\n" + 
        	  		"        </tr>\n" + 
        	  		"\n" + 
        	  		"        <tr>\n" + 
        	  		"            <td height=\"25\" style=\"font-size: 25px; line-height: 25px;\">&nbsp;</td>\n" + 
        	  		"        </tr>\n" + 
        	  		"\n" + 
        	  		"    </table>\n" + 
        	  		"    <!-- end footer ====== -->\n" + 
        	  		"\n" + 
        	  		"</body>\n" + 
        	  		"\n" + 
        	  		"</html>";
        	    helper.setText(htmlText,true);
        	    mailSender.send(mime);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
         }
     }
}
