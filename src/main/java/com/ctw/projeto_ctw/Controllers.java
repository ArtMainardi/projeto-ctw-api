package com.ctw.projeto_ctw;

import com.ctw.projeto_ctw.mrsc.alunos.model.Alunos;
import com.ctw.projeto_ctw.mrsc.alunos.service.AlunosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")

public class Controllers {
    final AlunosService alunosService;
    @RequestMapping("/login")
    public Map<String, String> login(@RequestBody Login data){
        Map<String, String> response = new HashMap<>();
        List<Alunos> alunos = alunosService.listar();

        if(alunos.isEmpty()){
            response.put("message", "Lista de usuários vazia!");
            return response;
        }

        response.put("message", "Finished");
        return response;
    }
}
