
public class Main {

    public static void main(String[] args) {

        Payment payment = new UpiPayment();

        PaymentService service = new PaymentService();

        service.processPayment(payment);

    }

}