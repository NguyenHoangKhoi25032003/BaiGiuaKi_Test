package fit.iuh;

public class Main
{

    public static void main(String[] args) {
        // Interface cho chiến lược thanh toán
        interface PaymentStrategy {
            void pay(double amount);
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

        // Thanh toán bằng Tiền mặt
        context.setPaymentStrategy(new CashPayment());
        context.pay(100.0);

        // Thanh toán bằng Chuyển khoản
        context.setPaymentStrategy(new BankTransferPayment());
        context.pay(200.0);

        // Thanh toán bằng Momo
        context.setPaymentStrategy(new MomoPayment());
        context.pay(300.0);
    }
}
