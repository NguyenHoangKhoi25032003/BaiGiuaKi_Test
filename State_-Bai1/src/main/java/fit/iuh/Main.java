package fit.iuh;

// Interface trạng thái thanh toán
interface PaymentState {
    void handlePayment(PaymentContext context);
}

// Trạng thái: Chờ thanh toán
class PendingPayment implements PaymentState {
    public void handlePayment(PaymentContext context) {
        System.out.println("Trạng thái: Chờ thanh toán. Đang xử lý...");
        context.setState(new CompletedPayment());
    }
}

// Trạng thái: Đã thanh toán
class CompletedPayment implements PaymentState {
    public void handlePayment(PaymentContext context) {
        System.out.println("Trạng thái: Đã thanh toán thành công.");
    }
}

// Trạng thái: Hủy thanh toán
class CanceledPayment implements PaymentState {
    public void handlePayment(PaymentContext context) {
        System.out.println("Trạng thái: Thanh toán bị hủy.");
    }
}

// Context chứa trạng thái thanh toán
class PaymentContext {
    private PaymentState state;

    public PaymentContext() {
        this.state = new PendingPayment(); // Mặc định là Chờ thanh toán
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public void processPayment() {
        state.handlePayment(this);
    }
}





public class Main {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Xử lý thanh toán (từ Chờ thanh toán -> Đã thanh toán)
        context.processPayment();

        // Thay đổi trạng thái thành Hủy thanh toán và xử lý tiếp
        context.setState(new CanceledPayment());
        context.processPayment();
    }
}