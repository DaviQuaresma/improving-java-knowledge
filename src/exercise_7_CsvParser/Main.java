package exercise_7_CsvParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\daviq\\IdeaProjects\\JavaCoreAndLogicsPractice\\src\\exercise_7_CsvParser\\test.csv";
        List<String> chaves = new ArrayList<>();
        String text = "";
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if(Files.exists(Path.of(path))){
                System.out.println("File " + path + " exists");
            }

            File file = new File(path);

            Scanner scanner = new Scanner(file);
            UserManagment  userManagment = new UserManagment();

            if (scanner.hasNextLine()) {
                Collections.addAll(chaves, scanner.nextLine().split(","));
            }

            while (scanner.hasNextLine()) {
                text += scanner.nextLine() + "\n";
            }

            List<Map<String, String>> list = text.lines()
                .map(linha -> linha.split(","))
                .map(valores -> Map.of(
                        chaves.get(0), valores[0],
                        chaves.get(1), valores[1],
                        chaves.get(2), valores[2],
                        chaves.get(3), valores[3],
                        chaves.get(4), valores[4]
                ))
                .toList();

            for(Map<String, String> map : list){
                userManagment.addUser(map.get("name"), Integer.parseInt(map.get("age")), map.get("phone"), map.get("email"), formatador.parse(map.get("date")));
            }

            userManagment.getUsers();

        } catch (FileNotFoundException e) {
            System.out.println("File not found:  " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}


//7. Parser de arquivos CSV
//
//Leia um CSV e transforme cada linha em objeto.
//        Use: Files, Streams, Exceptions.