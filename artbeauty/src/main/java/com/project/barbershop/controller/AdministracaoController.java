package com.project.barbershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/art-beauty/admin")
public class AdministracaoController {

    public void generateReport(){

    }

    public void generatePromotion(){
        /*
        a ideia aqui é criar uma promoção e enviar para todos os users que
        possuam telefone (zap) cadastrados no sistema no sistema
         */
    }

}
