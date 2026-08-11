package exercise_6_CpfCnpjValidator;

public class CnpjValidator implements DocValidator {

    String cnpj;

    public CnpjValidator(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean isFormated() {
        String regex = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}";
        return this.cnpj.matches(regex);
    }

    @Override
    public boolean haveCaracters() {
        return !this.cnpj.matches(".*[a-zA-Z].*");
    }

    @Override
    public boolean isValid() {

        if (!isFormated()) {
            return false;
        }

        String cnpjRaw = this.cnpj
                .replace(".", "")
                .replace("/", "")
                .replace("-", "");

        int digito1 = getDigito1();
        int digito2 = getDigito2();

        int cnpjDigito1 = Integer.parseInt(String.valueOf(cnpjRaw.charAt(12)));
        int cnpjDigito2 = Integer.parseInt(String.valueOf(cnpjRaw.charAt(13)));

        return digito1 == cnpjDigito1 && digito2 == cnpjDigito2;
    }

    @Override
    public int getDigito1() {

        String cnpjRaw = this.cnpj
                .replace(".", "")
                .replace("/", "")
                .replace("-", "");

        int[] weights = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;

        for (int i = 0; i < 12; i++) {
            int numero = Integer.parseInt(String.valueOf(cnpjRaw.charAt(i)));
            soma += numero * weights[i];
        }

        int resto = soma % 11;

        if (resto < 2) {
            return 0;
        }

        return 11 - resto;
    }

    @Override
    public int getDigito2() {

        String cnpjRaw = this.cnpj
                .replace(".", "")
                .replace("/", "")
                .replace("-", "");

        int[] weights = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;

        for (int i = 0; i < 13; i++) {
            int numero = Integer.parseInt(String.valueOf(cnpjRaw.charAt(i)));

            // No cálculo do segundo dígito,
            // o primeiro dígito verificador já está na posição 12.
            soma += numero * weights[i];
        }

        int resto = soma % 11;

        if (resto < 2) {
            return 0;
        }

        return 11 - resto;
    }

    String returnCnpj() {

        if (!isFormated()) {
            System.out.println(
                    "O CNPJ não está no formato correto: 00.000.000/0000-00"
            );
            return this.cnpj;
        }

        if (!isValid()) {
            System.out.println("Esse CNPJ não é válido: " + this.cnpj);
        }

        return this.cnpj;
    }
}