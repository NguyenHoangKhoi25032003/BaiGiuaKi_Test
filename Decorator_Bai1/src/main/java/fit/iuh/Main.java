package fit.iuh;

public class Main {
    public static void main(String[] args) {
        // Interface cho chiến lược thanh toán
        interface PaymentStrategy {
            void pay(double amount);
        }

        // Lớp Decorator để thêm chức năng cho phương thức thanh toán
        abstract class PaymentDecorator implements PaymentStrategy {
            protected PaymentStrategy decoratedPayment;

            public PaymentDecorator(PaymentStrategy decoratedPayment) {
                this.decoratedPayment = decoratedPayment;
            }

            public void pay(double amount) {
                decoratedPayment.pay(amount);
            }
        }

        // Decorator thêm chức năng ghi log giao dịch
        class LoggingPaymentDecorator extends PaymentDecorator {
            public LoggingPaymentDecorator(PaymentStrategy decoratedPayment) {
                super(decoratedPayment);
            }

            public void pay(double amount) {
                System.out.println("[LOG] Đang thực hiện giao dịch: " + amount);
                super.pay(amount);
                System.out.println("[LOG] Giao dịch hoàn tất.");
            }
        }

        // Decorator thêm chức năng xác thực trước khi thanh toán
        class SecurePaymentDecorator extends PaymentDecorator {
            public SecurePaymentDecorator(PaymentStrategy decoratedPayment) {
                super(decoratedPayment);
            }

            public void pay(double amount) {
                System.out.println("[SECURITY] Xác thực giao dịch trước khi thanh toán...");
                super.pay(amount);
            }
        }

        // Thanh toán bằng Tiền mặt
        class CashPayment implements PaymentStrategy {
            public void pay(double amount) {
                System.out.println("Thanh toán " + amount + " bằng Tiền mặt.");
            }
        }

        // Thanh toán bằng Chuyển khoản
        class BankTransferPayment implements PaymentStrategy {
            public void pay(double amount) {
                System.out.println("Thanh toán " + amount + " bằng Chuyển khoản ngân hàng.");
            }
        }

        // Thanh toán bằng Momo
        class MomoPayment implements PaymentStrategy {
            public void pay(double amount) {
                System.out.println("Thanh toán " + amount + " qua Momo.");
            }
        }

        // Thanh toán bằng VNPay
        class VNPayPayment implements PaymentStrategy {
            public void pay(double amount) {
                System.out.println("Thanh toán " + amount + " qua VNPay.");
            }
        }

        // Thanh toán bằng ZaloPay
        class ZaloPayPayment implements PaymentStrategy {
            public void pay(double amount) {
                System.out.println("Thanh toán " + amount + " qua ZaloPay.");
            }
        }

        // Thanh toán bằng Thẻ tín dụng
        class CreditCardPayment implements PaymentStrategy {
            public void pay(double amount) {
                System.out.println("Thanh toán " + amount + " bằng Thẻ tín dụng.");
            }
        }

        // Context chứa phương thức thanh toán
        class PaymentContext {
            private PaymentStrategy paymentStrategy;

            public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
                this.paymentStrategy = paymentStrategy;
            }

            public void pay(double amount) {
                paymentStrategy.pay(amount);
            }
        }

        PaymentContext context = new PaymentContext();

        // Thanh toán bằng Tiền mặt có log
        context.setPaymentStrategy(new LoggingPaymentDecorator(new CashPayment()));
        context.pay(100.0);

        // Thanh toán bằng Chuyển khoản có bảo mật
        context.setPaymentStrategy(new SecurePaymentDecorator(new BankTransferPayment()));
        context.pay(200.0);

        // Thanh toán bằng Momo có bảo mật và log
        context.setPaymentStrategy(new LoggingPaymentDecorator(new SecurePaymentDecorator(new MomoPayment())));
        context.pay(300.0);
    }


}
