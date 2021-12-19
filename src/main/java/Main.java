import java.io.*;
import java.util.LinkedList;
import java.util.Arrays;

/**
 *класс мейн
 */
public class Main {
    /**
     * Считываем и создаем список
     * @param args аргумент командной строки
     */
    public static void main(String[] args) {
        String csvFilePath = "foreign_names.csv";// файл архив
        String str = "";//созадали пустую строку для хранения архива
//пытаемся считать в строку
        try {
            FileReader reader = new FileReader(csvFilePath);// с помощью этого метода считываем архив файл
            char[] massChar = new char[256];// массив
            int tempStr = reader.read(massChar);//считываем в массив

            while(tempStr == 256){//если конец файла tempStr!=256
                String tmp = new String(massChar);//создает строку
                str += tmp;//добавляем
                tempStr = reader.read(massChar);//считывает строку из 256 элементов в massChar
            }
//считаем последние символы
            massChar = Arrays.copyOf(massChar, tempStr);//
            String tmp = new String(massChar);//
            str += tmp;
        }
//если не получилось ошибка
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        LinkedList<Person> listPerson = new LinkedList<>();//создаем список типа человека
        String[] oneline = str.split("\r\n");//каждый элемент списка, это информация про человека
//split - считывает до разделителя\r\n" String[]- массив стринг оф хранит строки
        for(int i = 1; i < oneline.length; i++) {  //разбивает на слова строку
            listPerson.addLast(new Person(oneline[i].split(";"))); //split - считывает до разделителя ;
        }

        for (Person pers : listPerson) {//выводит
            pers.print();
        }
    }
}
