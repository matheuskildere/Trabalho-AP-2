import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.DataInputStream;

public class Testes{
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        
        Scanner input = new Scanner(System.in);
        System.out.printf("\nInsira o nome do arquivo que deseja abrir: ");
        String option1 = input.nextLine();
        try{
        FileInputStream fileRead = new FileInputStream("./events/"+option1+".dat");
        DataInputStream readFile = new DataInputStream(fileRead);
        String arquivo = readFile.readUTF();
        String cidade = readFile.readUTF();
        String uf = readFile.readUTF();
        String dateInitial = readFile.readUTF();
        String dateEnd = readFile.readUTF();
        String nameResponsible = readFile.readUTF();
        int workload = readFile.readInt();
        System.out.printf("\nArquivo: %s",arquivo);
        System.out.printf("\nArquivo: %s",cidade);
        System.out.printf("\nArquivo: %s",uf);
        System.out.printf("\nArquivo: %s",dateInitial);
        System.out.printf("\nArquivo: %s",dateEnd);
        System.out.printf("\nArquivo: %s",nameResponsible);
        System.out.printf("\nArquivo: %d\n",workload);
        fileRead.close();
        input.close(); 
        }catch(FileNotFoundException varException){
            System.out.println("ERRO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nDA PROXIMA BOTA UM NOME REAL OTARIO");
        }
    }
}