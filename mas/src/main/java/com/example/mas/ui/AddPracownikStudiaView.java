package com.example.mas.ui;
import com.example.mas.deweloper.Deweloper;
import com.example.mas.deweloper.DeweloperDTO;
import com.example.mas.pracownikStudia.PracownikStudiaDTO;
import com.example.mas.pracownikStudia.PracownikStudiaDoZapisuDTO;
import com.example.mas.tester.TesterDTO;
import com.example.mas.testerEndToEnd.TesterEndToEndDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Route("dodaj-pracownika-studia")
public class AddPracownikStudiaView extends VerticalLayout {
    private final RestTemplate restTemplate;

    private Long id;
    private String imie;
    private String nazwisko;
    private boolean aktualnyStatusZatrudnienia;


    private final TextField imieField = new TextField("Imie");
    private final TextField nazwiskoField = new TextField("Nazwisko");
    private final TextField adresZamieszkaniaField = new TextField("Adres zamieszkania");
    //private final BooleanField aktualnyStatusField = new BooleanField("Aktualny status");



    private final Button addButton = new Button("Dodaj nowego pracownika");
    private final Button cancelButton = new Button("Anuluj");
    private final Button homePageButton = new Button("Strona glowna");


    public AddPracownikStudiaView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        ComboBox<String> stanowiskoComboBox = new ComboBox<>("Wybierz stanowisko");
        stanowiskoComboBox.setItems("Deweloper", "Tester", "Tester-End-To-End");

        MultiSelectComboBox<String> jezykiComboBox = new MultiSelectComboBox<>("Wybierz jezyki programowania");
        jezykiComboBox.setItems("Java", "Python", "JavaScript", "C++", "Kotlin");
        jezykiComboBox.setVisible(false);
        jezykiComboBox.setPlaceholder("Wybierz jezyki programowania");

        stanowiskoComboBox.addValueChangeListener(event -> {
            if ("Deweloper".equals(event.getValue())) {
                jezykiComboBox.setVisible(true);
            } else {
                jezykiComboBox.setVisible(false);
            }
        });


        Set<String> wybraneJezyki = new HashSet<>(jezykiComboBox.getValue());

        cancelButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("/")));
        addButton.addClickListener(e -> {
            String stanowisko = stanowiskoComboBox.getValue();

            if (stanowisko == null) {
                Notification.show("Proszę wybrać stanowisko.", 3000, Notification.Position.MIDDLE);
                return;
            }

        if(imieField.getValue() == null || imieField.getValue().isEmpty() || nazwiskoField.getValue() == null || nazwiskoField.getValue().isEmpty()) {
            Notification.show("Podaj wymagane dane", 3000, Notification.Position.MIDDLE);
        }
        else {
            if (stanowisko.equals("Deweloper")) {
                if (jezykiComboBox.getValue().size() < 2) {
                    Notification.show("Proszę wybrać co najmniej dwa języki programowania.", 3000, Notification.Position.MIDDLE);
                    return;
                }
                DeweloperDTO deweloperDTO = new DeweloperDTO(imieField.getValue(), nazwiskoField.getValue(), true, LocalDate.now(), wybraneJezyki.stream().toList());
                DeweloperDTO deweloperPoZapise = registerNewDeweloper(deweloperDTO);
                Notification.show(deweloperPoZapise.getImie() + " " + deweloperPoZapise.getNazwisko() + " dodany pomyslnie", 3000, Notification.Position.MIDDLE);

            } else if (stanowisko.equals("Tester")) {
                TesterDTO testerDTO = new TesterDTO(imieField.getValue(), nazwiskoField.getValue(), true, LocalDate.now());
                TesterDTO testerPoZapisie = registerNewTester(testerDTO);
                Notification.show(testerPoZapisie.getImie() + " " + testerPoZapisie.getNazwisko() + " dodany pomyslnie", 3000, Notification.Position.MIDDLE);

            } else if (stanowisko.equals("Tester-End-To-End")) {
                TesterEndToEndDTO testerEndToEndDTO = new TesterEndToEndDTO(imieField.getValue(), nazwiskoField.getValue(), true, LocalDate.now());
                TesterEndToEndDTO testerEndToEndPoZapisie = registerNewTesterEndToEnd(testerEndToEndDTO);
                Notification.show(testerEndToEndPoZapisie.getImie() + " " + testerEndToEndPoZapisie.getNazwisko() + " dodany pomyslnie", 3000, Notification.Position.MIDDLE);
            }


            getUI().ifPresent(ui -> ui.navigate("/"));
        }
        });

        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, addButton);
        add(imieField, nazwiskoField, stanowiskoComboBox, jezykiComboBox, buttonLayout);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();
    }

    public PracownikStudiaDTO registerNewPracownikStudia () {
        String url = "http://localhost:8080/api/v1/pracownikstudia/add-pracownik-studia";
        DatePicker dataDodaniaPracownika = new DatePicker("");
        dataDodaniaPracownika.setValue(LocalDate.now());
        PracownikStudiaDoZapisuDTO dto = new PracownikStudiaDoZapisuDTO(imieField.getValue(), nazwiskoField.getValue(), true, dataDodaniaPracownika.getValue());
        return restTemplate.postForObject(url, dto, PracownikStudiaDTO.class);
    }

    public DeweloperDTO registerNewDeweloper(DeweloperDTO deweloperDTO) {
        String url = "http://localhost:8080/api/v1/deweloper/add-deweloper";
        return restTemplate.postForObject(url, deweloperDTO, DeweloperDTO.class);
    }

    public TesterDTO registerNewTester(TesterDTO testerDTO) {
        String url = "http://localhost:8080/api/v1/tester/add-tester";
        return restTemplate.postForObject(url, testerDTO, TesterDTO.class);
    }

    public TesterEndToEndDTO registerNewTesterEndToEnd(TesterEndToEndDTO testerEndToEndDTO) {
        String url = "http://localhost:8080/api/v1/testerEndToEnd/add-tester-end-to-end";
        return restTemplate.postForObject(url, testerEndToEndDTO, TesterEndToEndDTO.class);
    }


}
