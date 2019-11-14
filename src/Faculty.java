public class Faculty extends Student{
    public int classId;
    public Faculty(){};
    public Faculty(int id,int classID, String name, String email, String password){

        this.id = id;
        this.classId = classID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String message(){
        return " ";
    }
}
