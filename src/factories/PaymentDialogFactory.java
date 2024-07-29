package factories;

import controllers.CreditCardController;
import controllers.IPaymentController;
import controllers.MainController;
import controllers.PayPalController;
import enums.PaymentType;
import views.MainScreen;
import views.dialogs.CreditCardDialog;
import views.dialogs.PayPalDialog;
import views.dialogs.PaymentDialog;

import java.util.HashMap;
import java.util.function.Supplier;

public class PaymentDialogFactory {

    private static final HashMap<PaymentType, Supplier<PaymentDialog>> dialogMap = new HashMap<>();
    private static final HashMap<PaymentType, IPaymentController> dialogControllerMap = new HashMap<>();

    public static void initialize(MainController mainController) {
        dialogMap.put(PaymentType.PAY_PAL, () -> new PayPalDialog(MainScreen.getInstance()));
        dialogMap.put(PaymentType.CREDIT_CARD, () -> new CreditCardDialog(MainScreen.getInstance()));

        dialogControllerMap.put(PaymentType.PAY_PAL, new PayPalController(mainController));
        dialogControllerMap.put(PaymentType.CREDIT_CARD, new CreditCardController(mainController));
    }

    public static void displayPaymentDialog(String type) {
        PaymentDialog dialog = dialogMap.get(PaymentType.valueOf(type)).get();
        initializeController(dialog, type);
        dialog.showDialog(true);
    }

    private static void initializeController(PaymentDialog dialog, String type) {
        IPaymentController controller = dialogControllerMap.get(PaymentType.valueOf(type));
        controller.setDependencies(dialog);
        controller.initControllerPostDisplay();
    }
}
