package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {


    // Puxar informacoes
    @GetMapping("/boasvindas")

    public String boasVindas() {

        return "Essa é a minha primeira mensagem nessa rota";

    }


}
