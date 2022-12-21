package inheritance;

public class B extends A{

     public B(){
        super();
        System.out.println("B Initialised");
    }

    public void katch(){
        System.out.println("B catches");
    }

    public void katch(int i){
        System.out.println("B catches "+i);
    }

    public void run(){
        System.out.println("B runs");
    }
}
