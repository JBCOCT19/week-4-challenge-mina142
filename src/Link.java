public class Link {
    private int id;
    private int facultyID;
    private int studnetID;
    private String date;
    public Link(){}
    public Link(int id,int studnetID, int facultyID,  String date){
        this.id = id;
        this.studnetID = studnetID;
        this.facultyID=facultyID;
        this.date= date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public int getStudnetID() {
        return studnetID;
    }

    public void setStudnetID(int studnetID) {
        this.studnetID = studnetID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
