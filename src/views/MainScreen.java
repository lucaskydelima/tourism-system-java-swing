package views;

import controllers.*;
import facades.PaymentManager;
import facades.ReservationManager;
import models.memento.CareTaker;
import models.memento.Originator;
import repositories.ReservationRepository;
import services.ReservationService;
import views.panels.*;

import javax.swing.*;

public class MainScreen extends JFrame {

    private static MainScreen mainScreen;
    private CustomerPanel customerPanel;
    private PackageOfferPanel packageOfferPanel;
    private CustomTripPanel customTripPanel;
    private PaymentMethodPanel paymentMethodPanel;
    private TripServicePanel tripServicePanel;
    private AgencyPanel agencyPanel;
    private TripSummaryPanel tripSummaryPanel;

    private MainController mainController;
    private CustomerController customerController;
    private PackageOfferController packageOfferController;
    private CustomTripController customTripController;
    private PaymentMethodController paymentMethodController;
    private TripServiceController tripServiceController;
    private AgencyController agencyController;
    private TripSummaryController tripSummaryController;

    private ReservationManager reservationManager;
    private PaymentManager paymentManager;

    private ReservationService reservationService;
    private ReservationRepository reservationRepository;

    private Originator originator;
    private CareTaker careTaker;

    private MainScreen() {
        initializeComponents();
        initializeControllers();
        setupDependencies();
        initializeControllersPostSetup();
        setupLayout();
    }

    public static JFrame getInstance() {

        if (mainScreen == null) {
            mainScreen = new MainScreen();
            mainScreen.setVisible(true);
            mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainScreen.setTitle("Tourist Agency System");
            mainScreen.setBounds(0, 0, 1200, 800);
            mainScreen.setLocationRelativeTo(null);
        }

        return mainScreen;
    }

    private void setupLayout() {
        setLayout(null);
        add(customerPanel);
        add(paymentMethodPanel);
        add(agencyPanel);
        add(packageOfferPanel);
        add(tripServicePanel);
        add(tripSummaryPanel);
        add(customTripPanel);
    }

    private void initializeComponents() {
        customerPanel = new CustomerPanel();
        packageOfferPanel = new PackageOfferPanel();
        customTripPanel = new CustomTripPanel();
        paymentMethodPanel = new PaymentMethodPanel();
        tripServicePanel = new TripServicePanel();
        agencyPanel = new AgencyPanel();
        tripSummaryPanel = new TripSummaryPanel();
    }

    private void initializeControllers() {

        // Inicializa os facades, services e repository
        reservationManager = new ReservationManager();
        paymentManager = new PaymentManager();
        reservationService = new ReservationService();
        reservationRepository = new ReservationRepository();


        originator = new Originator();
        careTaker = new CareTaker();

        // Inicializa os controladores sem dependências
        mainController = new MainController();
        mainController.initializeFactory();

        customerController = new CustomerController();
        packageOfferController = new PackageOfferController();
        customTripController = new CustomTripController();
        paymentMethodController = new PaymentMethodController();
        tripServiceController = new TripServiceController();
        agencyController = new AgencyController();
        tripSummaryController = new TripSummaryController();
    }

    private void setupDependencies() {
        mainController.setDependencies(customerController,
                packageOfferController, customTripController, paymentMethodController, tripServiceController,
                agencyController, tripSummaryController, reservationManager, paymentManager, reservationService);

        // Configura as dependências dos outros controladores
        customerController.setDependencies(customerPanel, mainController);
        packageOfferController.setDependencies(packageOfferPanel, mainController);
        customTripController.setDependencies(customTripPanel, mainController);
        paymentMethodController.setDependencies(paymentMethodPanel, mainController);
        tripServiceController.setDependencies(tripServicePanel, mainController);
        agencyController.setDependencies(agencyPanel, mainController);
        tripSummaryController.setDependencies(tripSummaryPanel, mainController);


        // Configura as dependências dos facades
        reservationManager.setControllers(customerController, packageOfferController, customTripController,
                paymentMethodController, reservationRepository, originator, careTaker);

        reservationService.setDependencies(reservationRepository);
    }

    private void initializeControllersPostSetup() {
        // Inicializa os controladores após configurar as dependências
        customerController.initController();
        packageOfferController.initController();
        customTripController.initController();
        agencyController.initController();
    }
}
