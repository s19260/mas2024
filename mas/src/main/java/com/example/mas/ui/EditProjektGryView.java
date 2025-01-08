package com.example.mas.ui;

import com.example.mas.projektGry.ProjektGryDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import org.springframework.web.client.RestTemplate;

@Route("edit-projekt-gry/:id")
public class EditProjektGryView extends VerticalLayout implements BeforeEnterObserver {
    private final RestTemplate restTemplate;

    private final NumberField idField = new NumberField("ID");
    private final NumberField budzetField = new NumberField("Budżet");
    private final NumberField kosztMarketinguField = new NumberField("Koszt Marketingu");
    private final NumberField kosztUtrzymaniaZespoluField = new NumberField("Koszt Utrzymania Zespołu");
    private final TextField wymaganySprzetField = new TextField("Wymagany Sprzęt");

    private final Button saveButton = new Button("Zapisz");
    private final Button cancelButton = new Button("Cofnij");

    private String projektId;

    public EditProjektGryView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        idField.isReadOnly();
        budzetField.setMin(0);
        kosztMarketinguField.setMin(0);
        kosztUtrzymaniaZespoluField.setMin(0);

        saveButton.addClickListener(e -> saveProjektGry());
        cancelButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("projekt-gry-view")));

        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, saveButton);
        add(idField,budzetField, kosztMarketinguField, kosztUtrzymaniaZespoluField, wymaganySprzetField, buttonLayout);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();
    }

    private void loadProjektGry(Long id) {

            String url = "http://localhost:8080/api/v1/projektgry/" + id;
            ProjektGryDTO projektGryDTO = restTemplate.getForObject(url, ProjektGryDTO.class);

            idField.setValue(Double.valueOf(id));
        budzetField.setValue(projektGryDTO.getBudzet() != null ? projektGryDTO.getBudzet().doubleValue() : null);
        kosztMarketinguField.setValue(projektGryDTO.getKosztMarketingu());
        kosztUtrzymaniaZespoluField.setValue(projektGryDTO.getKosztUtrzymaniaZespolu());
        wymaganySprzetField.setValue(projektGryDTO.getWymaganySprzet());

        budzetField.setEnabled(true);
        kosztMarketinguField.setEnabled(true);
        kosztUtrzymaniaZespoluField.setEnabled(true);
        wymaganySprzetField.setEnabled(true);

        saveButton.setEnabled(true);
        Notification.show("Pomyślnie załadowano projekt!!!", 3000, Notification.Position.MIDDLE);
    }

    private void saveProjektGry() {
        if (projektId == null) {
            Notification.show("Brak id projektu :(", 3000, Notification.Position.MIDDLE);
            return;
        }

        try {
            String url = "http://localhost:8080/api/v1/projektgry/" + projektId;
            restTemplate.put(url + "?sprzet=" + wymaganySprzetField.getValue()
                    + "&budzet=" + budzetField.getValue().longValue()
                    + "&kosztMarketingu=" + kosztMarketinguField.getValue()
                    + "&kosztUtrzymania=" + kosztUtrzymaniaZespoluField.getValue(), null);
            Notification.show("Projekt gry zedytowany pomyślnie!", 3000, Notification.Position.MIDDLE);
            getUI().ifPresent(ui -> ui.navigate("projekt-gry-view"));
        } catch (Exception ex) {
            Notification.show("Wystąpił błąd podczas zapisu: " + ex.getMessage(), 3000, Notification.Position.MIDDLE);
        }
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        projektId = beforeEnterEvent.getRouteParameters().get("id").orElse(null);

        if (projektId != null) {
            try {
                Long idParam = Long.parseLong(projektId);
                loadProjektGry(idParam);
            } catch (NumberFormatException ex) {
                Notification.show("Nieprawidłowe id projektu: " + projektId, 3000, Notification.Position.MIDDLE);
            }
        } else {
            Notification.show("Brak id projektu", 3000, Notification.Position.MIDDLE);
        }
    }
}

