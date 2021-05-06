import java.util.Objects;

public class WatchDog extends Dog{
    private int yearsOfTraining;

    public WatchDog() {
    }

    public WatchDog(String name, int yearsOfTraining) {
        super(name);
        this.yearsOfTraining = yearsOfTraining;
    }

    public int getYearsOfTraining() {
        return yearsOfTraining;
    }

    public void setYearsOfTraining(int yearsOfTraining) {
        this.yearsOfTraining = yearsOfTraining;
    }

    @Override
    public String toString() {
        String s = yearsOfTraining == 1 ? "" : "s";
        return "Hi, my name is " + this.getName() + " and i am a Watchdog. I have " + yearsOfTraining + " year" + s + " of training";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WatchDog watchDog = (WatchDog) o;
        return yearsOfTraining == watchDog.yearsOfTraining;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearsOfTraining);
    }
}
