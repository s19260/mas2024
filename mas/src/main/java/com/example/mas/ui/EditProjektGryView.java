package com.example.mas.ui;

import com.example.mas.liderZespolu.LiderZespolu;
import com.example.mas.liderZespolu.LiderZespoluDTO;
import com.example.mas.liderZespolu.LiderZespoluRepository;
import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.pracownikStudia.PracownikStudiaDTO;
import com.example.mas.projektGry.ProjektGryDTO;
import com.example.mas.projektGry.ProjektGryRepository;
import com.example.mas.projektGry.ProjektGryService;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@Route("edit-projekt-gry/:id")
public class EditProjektGryView extends VerticalLayout implements BeforeEnterObserver {
    private final RestTemplate restTemplate;

    private final NumberField idField = new NumberField("ID");
    private final NumberField budzetField = new NumberField("Budżet");
    private final NumberField kosztMarketinguField = new NumberField("Koszt Marketingu");
    private final NumberField kosztUtrzymaniaZespoluField = new NumberField("Koszt Utrzymania Zespołu");
    private final TextField wymaganySprzetField = new TextField("Wymagany Sprzęt");
    private final NumberField liderZespoluIdField = new NumberField("ID lidera zespolu");
    private final LiderZespolu idLiderZespolu = new LiderZespolu();
    private final ComboBox<LiderZespoluDTO> liderZespoluComboBox = new ComboBox<>("LiderZespolu");

    private final Button saveButton = new Button("Zapisz");
    private final Button cancelButton = new Button("Cofnij");
    private final Button deleteButton = new Button("Usun projekt");
    private final ProjektGryRepository projektGryRepository;
    private final ProjektGryService projektGryService;

    private String projektId;

    public EditProjektGryView(RestTemplate restTemplate, ProjektGryRepository projektGryRepository, ProjektGryService projektGryService) {
        this.restTemplate = restTemplate;

        idField.isReadOnly();
        budzetField.setMin(0);
        kosztMarketinguField.setMin(0);
        kosztUtrzymaniaZespoluField.setMin(0);

        ResponseEntity<LiderZespoluDTO[]> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/api/v1/liderZespolu/all", LiderZespoluDTO[].class);
        List<LiderZespoluDTO> liderzyZespolu = Arrays.asList(responseEntity.getBody());

        liderZespoluComboBox.setItems(liderzyZespolu);
        liderZespoluComboBox.setItemLabelGenerator(new ItemLabelGenerator<LiderZespoluDTO>() {
            @Override
            public String apply(LiderZespoluDTO liderZespoluDTO) {
                return liderZespoluDTO.getImie() + " " + liderZespoluDTO.getNazwisko();
            }
        });


        saveButton.addClickListener(e -> saveProjektGry());
        cancelButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("projekt-gry-view")));
        deleteButton.addClickListener(e -> deleteProjektGry());

        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, saveButton);
        add(idField, liderZespoluComboBox, budzetField, kosztMarketinguField, kosztUtrzymaniaZespoluField, wymaganySprzetField, deleteButton, buttonLayout);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();
        this.projektGryRepository = projektGryRepository;
        this.projektGryService = projektGryService;
    }

    private void loadProjektGry(Long id) {

        String url = "http://localhost:8080/api/v1/projektgry/" + id;
        ProjektGryDTO projektGryDTO = restTemplate.getForObject(url, ProjektGryDTO.class);

        idField.setValue(Double.valueOf(id));
        budzetField.setValue(projektGryDTO.getBudzet() != null ? projektGryDTO.getBudzet().doubleValue() : null);
        kosztMarketinguField.setValue(projektGryDTO.getBudzet() * 0.25);
        kosztUtrzymaniaZespoluField.setValue(projektGryDTO.getKosztUtrzymaniaZespolu());
        wymaganySprzetField.setValue(projektGryDTO.getWymaganySprzet());

        budzetField.setEnabled(true);
        kosztMarketinguField.setEnabled(true);
        kosztUtrzymaniaZespoluField.setEnabled(true);
        wymaganySprzetField.setEnabled(true);

        saveButton.setEnabled(true);
        Notification.show("Pomyślnie załadowano projekt!", 3000, Notification.Position.MIDDLE);
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
                    + "&liderZespoluId=" + liderZespoluComboBox.getValue().getId()
                    + "&kosztMarketingu=" + kosztMarketinguField.getValue()
                    + "&kosztUtrzymania=" + kosztUtrzymaniaZespoluField.getValue(),
                    null);
            Notification.show("Projekt gry zedytowany pomyślnie!", 3000, Notification.Position.MIDDLE);
            getUI().ifPresent(ui -> ui.navigate("projekt-gry-view"));
        } catch (Exception ex) {
            Notification.show("Wystąpił błąd podczas zapisu: " + ex.getMessage(), 3000, Notification.Position.MIDDLE);
        }
    }

    private void deleteProjektGry() {
        if (projektId == null) {
            Notification.show("Brak id projektu :(", 3000, Notification.Position.MIDDLE);
            return;
        }
        try {
            String url = "http://localhost:8080/api/v1/projektgry/";
            restTemplate.delete(url + projektId);
        } catch (Exception ex) {
            Notification.show("Wystąpił błąd podczas zapisu: " + ex.getMessage(), 3000, Notification.Position.MIDDLE);
        }
        getUI().ifPresent(ui -> ui.navigate("/projekt-gry-view"));
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

