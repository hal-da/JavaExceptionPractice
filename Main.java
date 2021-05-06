import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dog dog = new Dog("1");
        Dog dog1 = new Dog("2");
        Dog dog2 = new Dog("3");
        Dog dog3 = new Dog("4");
        Dog dog4 = new Dog("5");

        WatchDog watchDog1 = new WatchDog("6", 1);
        WatchDog watchDog2 = new WatchDog("7", 2);
        WatchDog watchDog3 = new WatchDog("8", 3);
        WatchDog watchDog4 = new WatchDog("9", 4);
        WatchDog watchDog5 = new WatchDog("10", 5);

        Dog[] dogs = {dog, dog1,dog2, dog3, dog4, watchDog1, watchDog2, watchDog3, watchDog4, watchDog5};

        WatchDog myWatchDog = null;
        System.out.println("Whats the dogs name you're looking for?");
        String myDogsName = sc.nextLine();



        try {
            myWatchDog = (WatchDog) findDogWithName(myDogsName, dogs);
        } catch (DogNotFoundException noDog){
            System.out.println("This is not the Dog you're looking for. Let me get you a brand new Dog");
            myWatchDog  = new WatchDog(myDogsName, 0);

        } catch (DogNotConvertibleException dogNoWatchdog) {
            System.out.println("This is not yet a Watchdog. Lets train " + myDogsName + " to become a watchdog");
            myWatchDog = new WatchDog();
            myWatchDog.setName(myDogsName);
            myWatchDog.setYearsOfTraining(0);
        } finally {
            System.out.println(myWatchDog);
        }



        sc.close();
    }

    private static Dog findDogWithName(String name, Dog[] dogs) throws DogNotFoundException, DogNotConvertibleException {
        Dog foundDog = null;

        for (Dog dog: dogs){
            if(dog.getName().equals(name)) foundDog = dog;
        };

       if(foundDog == null) throw new DogNotFoundException();
       if(!(foundDog instanceof WatchDog)) throw new DogNotConvertibleException();
       return foundDog;
    }
}
