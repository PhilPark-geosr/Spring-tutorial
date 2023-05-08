package ppark.pparkproject.controller;

public class MemberForm {
    private String wow;
    public String getName() {
        return wow;
    }

    // form 태그의 name의 key와 같아야 한다 즉, form태그의 name = 'wow'이면, String name이 아니라 String wow로 바꾸어 주어야 한다!
    public void setName(String name) {
        this.wow = name;
    }


}
