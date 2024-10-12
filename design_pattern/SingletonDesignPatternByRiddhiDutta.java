class TVSet {
    private static TVSet tvSetInstance = null;

    private TVSet() {
        System.out.println("TV Set Instantiated!");
    }

    public static TVSet getTVSetInstance() {
        if (tvSetInstance == null)
            tvSetInstance = new TVSet();
        return tvSetInstance;
    }
}

public class SingletonDesignPatternByRiddhiDutta {
    public static void main(String[] args) {
        // Member1
        TVSet tvSetForMember1 = TVSet.getTVSetInstance();
        // Member2
        TVSet tvSetForMember2 = TVSet.getTVSetInstance();
        System.out.println(tvSetForMember1);
        System.out.println(tvSetForMember2);
    }
}
