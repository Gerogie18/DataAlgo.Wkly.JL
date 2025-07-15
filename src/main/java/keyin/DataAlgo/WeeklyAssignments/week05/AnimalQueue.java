package keyin.DataAlgo.WeeklyAssignments.week05;

public class AnimalQueue {
    private Animal[] adoptionQueue;
    private int endOfQueue;
    private int beginningOfQueue;
    private int nItems;

    public AnimalQueue(int size) {
        this.adoptionQueue = new Animal[size];
        this.beginningOfQueue = -1;
        this.endOfQueue = -1;
        this.nItems = 0;
    }

    public boolean isFull() {
        return(endOfQueue==adoptionQueue.length -1);
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public void addAnimal(Animal animal) {
        if (isFull()) {
            System.out.println("The shelter is full, cannot accept " + animal);
        } else {
            if (isEmpty()) {
                beginningOfQueue = 0;
            }
            endOfQueue ++;
            adoptionQueue[endOfQueue] = animal;
            nItems++;
        }
    }

    /**
     * removes the last animal regardless of cat / dog
     * @return what was dequeued
     */
    public Animal adoptAnyAnimal() {
        if (isEmpty()) {
            System.out.println("The shelter is empty");
            return null;
        } else {
            Animal result = adoptionQueue[beginningOfQueue];
            adoptionQueue[beginningOfQueue] = null;
            beginningOfQueue++;
            // case: last item was dequeued
            if (beginningOfQueue > endOfQueue) {
                beginningOfQueue = -1;
                endOfQueue = -1;
            }
            nItems--;
            return result;
        }
    }

    public Animal adoptSpecificAnimal(Class<?> animal) {
        if (isEmpty()) {
            System.out.println("The shelter is empty");
            return null;
        }
        int foundIndex = -1;
        for (int i = beginningOfQueue; i<= endOfQueue; i++) {
            if (animal.isInstance(adoptionQueue[i])) {
                foundIndex = i;
                break;
            }
        }

        //case: no animal of that type found
        if (foundIndex == -1) {
            System.out.println("Shelter has no " +animal);
            return null;
        }

        Animal adoptedAnimal = adoptionQueue[foundIndex];

        //recreate the queue
        for (int i = foundIndex; i < endOfQueue; i++) {
            adoptionQueue[i] = adoptionQueue [i + 1];
        }

        //update pointers
        adoptionQueue[endOfQueue] = null;
        endOfQueue--;
        nItems--;

        //case: queue is now empty
        if (isEmpty()) {
            endOfQueue = -1;
            beginningOfQueue = -1;
        }
        return adoptedAnimal;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[empty]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = beginningOfQueue; i <= endOfQueue; i++) {
            sb.append(adoptionQueue[i].toString());
            if (i < endOfQueue) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

