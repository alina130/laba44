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
        String stingInfo = "";//созадали пустую строку для хранения архива
//пытаемся считать в строку
        try {
            FileReader reader = new FileReader(csvFilePath);// с помощью этого метода считываем архив файл
            char[] massInfo = new char[256];// массив
            int tempString = reader.read(massInfo);//считываем в массив

            while(tempString == 256){//считывает по 256 символов
                String tmp = new String(massInfo);//создает строку
                stingInfo += tmp;//добавляем
                tempString = reader.read(massInfo);//считывает строку из 256 элементов в massInfo
            }
//считаем последние символы
            massInfo = Arrays.copyOf(massInfo, tempString);
            String tmp = new String(massInfo);//добавляем их в массив massInfo
            stingInfo += tmp;
        }
//если не получилось ошибка
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        LinkedList<Person> listPerson = new LinkedList<>();//создаем список типа человека
        String[] oneline = stingInfo.split("\r\n");//каждый элемент списка, это информация про человека
//split - считывает до разделителя\r\n" String[]- хранит строки
        for(int i = 1; i < oneline.length; i++) {  //разбивает строку на слова
            listPerson.addLast(new Person(oneline[i].split(";"))); //split - считывает до разделителя ;
        }

        for (Person pers : listPerson) {//выводит
            pers.print();
        }
    }
}
