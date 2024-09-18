package com.Gtec.ProjetoGtec.service;

import com.Gtec.ProjetoGtec.dto.request.FuncionarioRequestDTO;
import com.Gtec.ProjetoGtec.dto.response.FuncionarioResponseDTO;
import com.Gtec.ProjetoGtec.entity.Funcionario;
import com.Gtec.ProjetoGtec.repository.FuncionarioRepository;
import com.Gtec.ProjetoGtec.util.FuncionarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    private final FuncionarioMapper funcionarioMapper;


    @Override
    public FuncionarioResponseDTO findById(Long id) {
        return funcionarioMapper.toFuncionarioDTO(returnFuncionario(id));
    }

    @Override
    public List<FuncionarioResponseDTO> findAll() {
        return funcionarioMapper.toFuncionariosDTO(funcionarioRepository.findAll());
    }

    @Override
    public FuncionarioResponseDTO register(FuncionarioRequestDTO funcionarioDTO) {

        Funcionario funcionario = funcionarioMapper.toFuncionario(funcionarioDTO);

        return funcionarioMapper.toFuncionarioDTO(funcionarioRepository.save(funcionario));
    }

    @Override
    public FuncionarioResponseDTO update(Long id, FuncionarioRequestDTO funcionarioDTO) {

        Funcionario funcionario = returnFuncionario(id);

        funcionarioMapper.updateFuncionarioData(funcionario,funcionarioDTO);

        return funcionarioMapper.toFuncionarioDTO(funcionarioRepository.save(funcionario));
    }

    @Override
    public String delete(Long id) {
        funcionarioRepository.deleteById(id);
        return "Funcionario id: "+id+" deleted";
    }

    private Funcionario returnFuncionario(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Funcionario não foi encontrado no banco de dados"));
    }
    
}
