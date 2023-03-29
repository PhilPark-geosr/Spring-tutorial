package ppark.pparkproject.controller;

public class MemberForm {
    private String name;
    public String getName() {
        return name;
    }

    // form 태그의 name의 key와 같아야 한다
    public void setName(String name) {
        this.name = name; 
    }


}
