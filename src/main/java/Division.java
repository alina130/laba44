/**
 *Класс подразделения
 */
public class Division {
    /**
     * два поля класса division
     */
    private int idDivision;//айди подразделения
    private String Nametitle;//имя подразделения

    /**
     *фуекция , передает число , и он присваивает ее айди подразделению
     * @param id
     */
    public void setIdDivision(int id) {
        this.idDivision = id;
    }

    /**
     *получение айди подразделения
     * @return
     */
    public int getIdDivision() {
        return idDivision;
    }

    /**
     *функция , передает строку , и он присваивает ее имени подразделению
     * @param title
     */
    public void setNametitle(String title) {
        this.Nametitle = title;
    }

    /**
     *получение имени подразделения
     * @return
     */
    public String getNametitle() {
        return Nametitle;
    }

}
