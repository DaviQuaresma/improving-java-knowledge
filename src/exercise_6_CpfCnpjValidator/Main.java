package exercise_6_CpfCnpjValidator;

public class Main {
    public static void main(String[] args) {

        CpfValidator cpf = new CpfValidator("022.712.866-46");
        CnpjValidator cnpj = new  CnpjValidator("58.484.857/0001-04");
        System.out.println(cpf.returnCpf());
        System.out.println(cnpj.returnCnpj());

    }
}
