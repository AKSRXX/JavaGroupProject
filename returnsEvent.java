import java.util.Date;

public class returnsEvent {
    private Member member;
    private Item item;
    private Date returnDate;

    public returnsEvent(Member member, Item item, Date returnDate) {
        this.member = member;
        this.item = item;
        this.returnDate = returnDate;
    }

    

    // Getters and setters for all attributes

    public void processReturn() {
        // Update item status and fines
        // ...
    }

    // Other methods for managing return events
}
