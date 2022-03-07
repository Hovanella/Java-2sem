package by.belstu.it.Hovansky;

public class Hello {

    public int getTest() {
        return test;
    }

    public Hello(int test) {
        this.test = test;
    }

    private int test;
    
    public String Hello(){
        return "Hello from first project";
    }
    
    public void onCreate(){
        for (int a = 0; a < 15; a++) {
            System.out.println("a : "+a);
        }
    }
}
