package exercise_6_CpfCnpjValidator;

import java.util.ArrayList;
import java.util.Arrays;

public class CpfValidator implements DocValidator {

    String cpf;

    public CpfValidator(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean isFormated() {
        String regex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

        if (!this.cpf.matches(regex)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean haveCaracters() {
        return !this.cpf.matches(".*[a-zA-Z].*");
    }

    @Override
    public boolean isValid() {
        if (!isFormated()) {
            return false;
        }

        String cpfRaw = cpf.replace(".", "").replace("-", "");

        int digito1 = getDigito1();
        int digito2 = getDigito2();

        int cpfDigito1 = Integer.parseInt(String.valueOf(cpfRaw.charAt(9)));
        int cpfDigito2 = Integer.parseInt(String.valueOf(cpfRaw.charAt(10)));

        return digito1 == cpfDigito1 && digito2 == cpfDigito2;
    }

    @Override
    public int getDigito1() {
        String cpfRaw = this.cpf.replace("-", "").replace(".", "");
        String[] cpfSplited = cpfRaw.split("");
        String[] weights = {"10", "9", "8", "7", "6", "5", "4", "3", "2"};
        int soma = 0;

        ArrayList<String> firstDigit = new ArrayList<>(Arrays.asList(cpfSplited));

        int j = 0;

        while (j < 2) {
            int last = firstDigit.size() - 1;
            firstDigit.remove(last);
            j += 1;
        }

        for (int i = 0; i < firstDigit.size(); i++) {
            soma += Integer.parseInt(firstDigit.get(i)) * Integer.parseInt(weights[i]);
        }

        int resto = soma % 11;

        int digito1;

        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        return digito1;
    }

    @Override
    public int getDigito2() {
        String cpfRaw = this.cpf.replace("-", "").replace(".", "");
        String[] cpfSplited = cpfRaw.split("");
        String[] weights = {"11", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        int soma = 0;

        ArrayList<String> firstDigit = new ArrayList<>(Arrays.asList(cpfSplited));

        String digito1 = String.valueOf(getDigito1());

        firstDigit.add(digito1);

        int j = 0;

        while (j < 2) {
            int last = firstDigit.size() - 1;
            firstDigit.remove(last);
            j += 1;
        }

        for (int i = 0; i < firstDigit.size(); i++) {
            soma += Integer.parseInt(firstDigit.get(i)) * Integer.parseInt(weights[i]);
        }

        int resto = soma % 11;

        int digito2;

        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        return digito2;
    }

    public String returnCpf() {

        if (!isValid()) {
            System.out.println("Esse CPF não é válido: " + this.cpf);
        }

        if (!haveCaracters()) {
            System.out.println("Tem letras no cpf: " + this.cpf);
        }

        if (!isFormated()) {
            System.out.println("O cpf não está no formato correto: 123.456.789-00");
        }

        return this.cpf;
    }


}
