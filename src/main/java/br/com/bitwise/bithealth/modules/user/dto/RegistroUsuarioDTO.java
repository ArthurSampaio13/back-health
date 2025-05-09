package br.com.bitwise.bithealth.modules.user.dto;

import br.com.bitwise.bithealth.modules.user.endereco.dto.EnderecoDTO;
import br.com.bitwise.bithealth.modules.user.model.ENUM.TipoUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegistroUsuarioDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
        String nome,
        @NotBlank(message = "Sobrenome é obrigatório")
        @Size(min = 2, max = 100, message = "Sobrenome deve ter entre 2 e 100 caracteres")
        String sobrenome,
        @NotBlank(message = "CPF é obrigatório")
        String cpf,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        @Size(max = 150, message = "Email não pode exceder 150 caracteres")
        String email,
        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
        String senha,
        @NotNull(message = "Tipo de usuário é obrigatório")
        TipoUsuario tipoUsuario,
        @NotNull(message = "Número de telefone é obrigatório")
        String numeroTelefone,
        @NotNull(message = "O endereço é obrigatório")
        @Valid
        EnderecoDTO endereco

) {
}
