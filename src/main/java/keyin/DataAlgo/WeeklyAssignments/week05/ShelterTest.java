package keyin.DataAlgo.WeeklyAssignments.week05;

public class ShelterTest {
    //created by llm

    public static void main(String[] args) {
        // Create a new shelter with a capacity of 5
        AnimalQueue shelter = new AnimalQueue(5);
        System.out.println("Current Shelter: " + shelter + "\n");

        // Add some animals to the shelter
        System.out.println("--- Adding Animals ---");
        shelter.addAnimal(new Cat("Whiskers"));
        shelter.addAnimal(new Cat("Shadow"));
        shelter.addAnimal(new Dog("Buddy"));
        shelter.addAnimal(new Cat("Smokey"));
        shelter.addAnimal(new Dog("Rocky"));
        System.out.println("Current Shelter: " + shelter + "\n");

        // Try to add an animal to a full shelter
        System.out.println("--- Attempting to Overfill Shelter ---");
        shelter.addAnimal(new Dog("Max"));
        System.out.println("Current Shelter: " + shelter + "\n");

        // Adopt the oldest dog (Buddy)
        System.out.println("--- Adopting a Dog ---");
        Animal adoptedDog = shelter.adoptSpecificAnimal(Dog.class);
        System.out.println("Adopted: " + adoptedDog);
        System.out.println("Current Shelter: " + shelter + "\n");

        // Adopt the oldest animal overall (Whiskers the Cat)
        System.out.println("--- Adopting Oldest Animal ---");
        Animal oldestAnimal = shelter.adoptAnyAnimal();
        System.out.println("Adopted: " + oldestAnimal);
        System.out.println("Current Shelter: " + shelter + "\n");

        // Adopt the oldest cat (Shadow)
        System.out.println("--- Adopting a Cat ---");
        Animal adoptedCat = shelter.adoptSpecificAnimal(Cat.class);
        System.out.println("Adopted: " + adoptedCat);
        System.out.println("Current Shelter: " + shelter + "\n");

        // Try to adopt a dog when there are none left
        System.out.println("--- Adopting a Dog (None Available) ---");
        shelter.adoptSpecificAnimal(Dog.class);
        System.out.println("Current Shelter: " + shelter + "\n");

        // Empty the rest of the shelter
        System.out.println("--- Emptying the Shelter ---");
        System.out.println("Adopted: " + shelter.adoptAnyAnimal()); // Smokey
        System.out.println("Adopted: " + shelter.adoptAnyAnimal()); // Rocky
        System.out.println("Current Shelter: " + shelter + "\n");

        // Try to adopt from an empty shelter
        System.out.println("--- Adopting from Empty Shelter ---");
        shelter.adoptAnyAnimal();
        System.out.println("Current Shelter: " + shelter + "\n");
    }
}