package com.ctw.projeto_ctw;

import com.ctw.projeto_ctw.mrsc.alunos.model.Alunos;
import com.ctw.projeto_ctw.mrsc.alunos.service.AlunosService;
import com.ctw.projeto_ctw.mrsc.professores.model.Professores;
import com.ctw.projeto_ctw.mrsc.professores.service.ProfessoresService;
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

public class LoginController {
    final AlunosService alunosService;
    final ProfessoresService professoresService;
    @RequestMapping("/login")
    public Map<String, String> login(@RequestBody LoginModel data){
        // Variáveis:
        Map<String, String> response = new HashMap<>();
        List<Alunos> alunos = alunosService.listar();
        List<Professores> professores = professoresService.listar();
        boolean emailVerify = false;
        String tipoUsuario = "";
        long usuarioId = 0;

        // Verificações:
        if(alunos.isEmpty() && professores.isEmpty()){
            response.put("message", "Lista de usuários vazia!");
            return response;
        } else {
            // Verificar email:
            for(long cont = 0; cont < alunos.size(); cont++){ // Verificando na tabela de alunos
                if(alunos.get((int)cont).getEmail_aluno().equals(data.getEmail())){
                    emailVerify = true;
                    tipoUsuario = "aluno";
                    usuarioId = cont+1;
                }
            }
            if(!emailVerify){
                for(long cont = 0; cont < professores.size(); cont++){ // Verificando na tabela de professores
                    if(professores.get((int)cont).getEmail_professor().equals(data.getEmail())){
                        emailVerify = true;
                        tipoUsuario = "professor";
                        usuarioId = cont+1;
                    }
                }
                if(!emailVerify){
                    response.put("message", "ERRO: email incorreto!");
                    return response;
                }
            }

            // Verificar senha:
            if(tipoUsuario == "aluno"){ // Verificando na tabela de alunos
                if(alunosService.buscar(usuarioId).getSenha_aluno().equals(data.getSenha())){
                    response.put("message", "Login efetuado com sucesso! (aluno)");
                } else{
                    response.put("message", "ERRO: senha incorreta!");
                    return response;
                }
            } else if(tipoUsuario == "professor"){ // Verificando na tabela de alunos
                if(professoresService.buscarPorId(usuarioId).getSenha_professor().equals(data.getSenha())){
                    response.put("message", "Login efetuado com sucesso! (professor)");
                } else{
                    response.put("message", "ERRO: senha incorreta!");
                    return response;
                }
            }

            // Retornando dados:
            response.put("tipoUsuario", tipoUsuario);
            response.put("usuarioId", String.valueOf(usuarioId));
            return response;
        }
    }
}
