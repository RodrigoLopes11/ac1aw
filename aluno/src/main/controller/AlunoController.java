import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private List<Aluno> alunos = new ArrayList<>();
    private Long proximoId = 1L;

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        aluno.setId(proximoId++);
        alunos.add(aluno);
        return aluno;
    }

    @GetMapping
    public List<Aluno> obterAlunos() {
        return alunos;
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                aluno.setNome(alunoAtualizado.getNome());
                aluno.setMatricula(alunoAtualizado.getMatricula());
                aluno.setCurso(alunoAtualizado.getCurso());
                aluno.setEmail(alunoAtualizado.getEmail());
                aluno.setTelefone(alunoAtualizado.getTelefone());
                return aluno;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunos.removeIf(aluno -> aluno.getId().equals(id));
    }
}
