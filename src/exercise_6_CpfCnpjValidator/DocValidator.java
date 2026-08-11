package exercise_6_CpfCnpjValidator;

public interface DocValidator {
    boolean isFormated();
    boolean haveCaracters();
    boolean isValid();
    int getDigito1();
    int getDigito2();
}
