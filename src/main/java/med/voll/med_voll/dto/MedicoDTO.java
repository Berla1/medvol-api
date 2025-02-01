package med.voll.med_voll.dto;

public record MedicoDTO(String nome,
                        String email,
                        String crm,
                        EspecialidadeDTO especialidade,
                        EnderecoDTO endereco) {

    @Override
    public String toString() {
        return
                "------------------------------\n" +
                "Nome: " + nome + "\n" +
                "Email: " + email + "\n" +
                "CRM: " + crm + "\n" +
                "Especialidade: " + especialidade + "\n" +
                "\nEndereço:\n " + endereco;
    }
}
