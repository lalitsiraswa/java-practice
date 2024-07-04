class TVSet {
    private static volatile TVSet tvSetINstance = null;

    private TVSet() {
        System.out.println("TV Set Instantiated!");
    }

    public static TVSet getTVSetInstance() {
        if (tvSetINstance == null) {
            synchronized (TVSet.class) {
                if (tvSetINstance == null)
                    tvSetINstance = new TVSet();
            }
        }
        return tvSetINstance;
    }
}

public class SingletonClass {
    public static void main(String[] args) {

    }
}
