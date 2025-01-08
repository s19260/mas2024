package com.example.mas.ui;
import com.example.mas.pracownikStudia.PracownikStudiaDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import org.springframework.web.client.RestTemplate;

@Route("edit-pracownik-studia/:id")
public class EditPracownikStudiaView extends VerticalLayout implements BeforeEnterObserver{
    private final RestTemplate restTemplate;

    private final NumberField idField = new NumberField("ID");
    private final TextField nameField = new TextField("Imie");
    private final TextField nazwiskoField = new TextField("Nazwisko");

    private final Button saveButton = new Button("Zapisz");
    private final Button cancelButton = new Button("Cofnij");

    private String pracownikID;

    public EditPracownikStudiaView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        idField.isReadOnly();

        saveButton.addClickListener(e -> savePracownikStudia());
        cancelButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("pracownik-studia-view")));

        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, saveButton);
        add(idField,nameField, nazwiskoField, buttonLayout);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();
    }

    private void loadPracownikStudia(Long id) {

        String url = "http://localhost:8080/api/v1/pracownikstudia/" + id;
        PracownikStudiaDTO pracownikStudiaDTO = restTemplate.getForObject(url, PracownikStudiaDTO.class);

        idField.setValue(Double.valueOf(id));
        nameField.setValue(pracownikStudiaDTO.getImie());
        nazwiskoField.setValue(pracownikStudiaDTO.getNazwisko());

        nameField.setEnabled(true);
        nazwiskoField.setEnabled(true);

        saveButton.setEnabled(true);
        Notification.show("Pomyslnie zaladowano", 3000, Notification.Position.MIDDLE);
    }

    private void savePracownikStudia() {
        if (pracownikID == null) {
            Notification.show("Brak id pracownika :(", 3000, Notification.Position.MIDDLE);
            return;
        }

        try{
            String url = "http://localhost:8080/api/v1/pracownikstudia/" + pracownikID;
            restTemplate.put(url + "?imie=" + nameField.getValue()
                    + "&nazwisko=" + nazwiskoField.getValue(), null);
            Notification.show("Pracownik zedytowany pomyslnie", 3000, Notification.Position.MIDDLE);
            getUI().ifPresent(ui -> ui.navigate("pracownik-studia-view"));
        } catch (Exception ex) {
            Notification.show("Wystapil blad podczas zapisy " + ex.getMessage(), 3000, Notification.Position.MIDDLE);
        }
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        pracownikID = beforeEnterEvent.getRouteParameters().get("id").orElse(null);

        if (pracownikID != null) {
            try{
                Long id = Long.parseLong(pracownikID);
                loadPracownikStudia(id);
            } catch (NumberFormatException ex) {
                Notification.show("Nieprawidlowe id pracownika :(", 3000, Notification.Position.MIDDLE);
}
            } else {
                Notification.show("Brak id pracownika :(", 3000, Notification.Position.MIDDLE);
            }
        }
    }

