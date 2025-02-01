package med.voll.med_voll.dto;

public record EnderecoDTO(String logradouro,
                          String bairro,
                          String cep,
                          String cidade,
                          String uf,
                          String numero,
                          String complemento) {

    @Override
    public String toString() {
        return  "Logradouro: " + logradouro + "\n" +
                " Bairro: " + bairro + "\n" +
                " CEP: " + cep + "\n" +
                " Cidade: " + cidade + "\n" +
                " UF: " + uf + "\n" +
                " Número: " + numero + "\n" +
                " Complemento: " + complemento + "\n" +
                "------------------------------"
                ;
    }
}
