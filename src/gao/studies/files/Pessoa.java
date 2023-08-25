package gao.studies.files;

import java.io.Serial;
import java.io.Serializable;

class Pessoa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;
    private String sexo;
    private int idade;

    public Pessoa(String nome, String sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return new String()
                .concat("Nome: ").concat(nome)
                .concat("\n")
                .concat("Sexo: ").concat(sexo)
                .concat("\n")
                .concat("Idade: ").concat(String.valueOf(idade));
    }
}
