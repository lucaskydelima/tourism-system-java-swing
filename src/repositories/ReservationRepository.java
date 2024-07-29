package repositories;

import models.memento.ReservationMemento;
import models.observer.Observer;

import java.io.*;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.Optional;
import java.util.TreeMap;

public class ReservationRepository implements Observer {

    private static final String FILE_PATH = "database.dat";
    private final File file;

    private TreeMap<String, ReservationMemento> reservationStorageMap;


    public ReservationRepository() {
        file = new File(FILE_PATH);
        ensureFileExists();
        load();
    }

    private void ensureFileExists() {
        if (!Files.exists(file.toPath())) {
            try {
                Files.createFile(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @SuppressWarnings("unchecked")
    public void load() {
        if (file.length() == 0) {
            reservationStorageMap = new TreeMap<>();
            return;
        }
        try (InputStream is = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(is)) {
            reservationStorageMap = (TreeMap<String, ReservationMemento>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            reservationStorageMap = new TreeMap<>();
        }
    }

    @Override
    public void update(TreeMap<String, ReservationMemento> reservationStateMap) {
        reservationStorageMap.putAll(reservationStateMap);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(reservationStorageMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<ReservationMemento> findByMobileNumber(String mobileNumber) {
        return reservationStorageMap.values().stream()
                .filter(r -> r.getReservation().getCustomer().getPhone().equals(mobileNumber))
                .max(Comparator.comparing(ReservationMemento::getToken));

    }
}
