package com.example.imobiliariaapp.Model;

import lombok.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    private String senha;
}


