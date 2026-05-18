// You will need a functioning Queue implementation (like LinkedQueue) for this to work.
interface Queue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E element);

    E dequeue();

    E first();
}

class LinkedQueue<E> implements Queue<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E element) {
        Node<E> newest = new Node<>(element, null);

        if (isEmpty()) {
            front = newest;
        } else {
            rear.next = newest;
        }
        rear = newest;
        size++;
    }

    public E dequeue() {

        if (isEmpty()) {
            return null;
        }

        E answer = front.element;
        front = front.next;
        size--;

        if (isEmpty()) {
            rear = null;
        }

        return answer;
    }

    public E first() {

        if (isEmpty()) {
            return null;
        }

        return front.element;
    }
}

/**
 * Represents a single document to be printed.
 */
class PrintJob {
    private String documentName;
    private int pageCount;

    // TODO: Implement the constructor
    public PrintJob(String documentName, int pageCount) {
        // Your code here

        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // TODO: Implement the toString method to return a descriptive string
    // e.g., "PrintJob[Document: report.docx, Pages: 15]"
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName +
                ", Pages: " + pageCount + "]";
    }
}

/**
 * Simulates a printer that manages a queue of print jobs.
 */
public class Printer {
    private Queue<PrintJob> jobQueue;

    public Printer() {
        // TODO: Initialize the jobQueue with a LinkedQueue
        jobQueue = new LinkedQueue<>();
    }

    /**
     * Adds a new print job to the rear of the queue.
     * 
     * @param job The print job to add.
     */
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        // TODO: Enqueue the job

        jobQueue.enqueue(job);
    }

    /**
     * Processes the job at the front of the queue.
     */
    public void processNextJob() {
        // TODO: Check if the queue is empty. If so, print a message.
        // If not empty, dequeue the job and print a "Processing..." message.

        if (jobQueue.isEmpty()) {
            System.out.println("No print jobs in queue.");
        } else {
            PrintJob nextJob = jobQueue.dequeue();
            System.out.println("Processing: " + nextJob);
        }
    }

    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx
        System.out.println("");
        System.out.println("New high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));
        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Should say the queue is empty
    }
}